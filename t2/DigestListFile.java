package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;
import java.security.MessageDigest;
import java.util.AbstractMap.SimpleEntry;
import java.util.Optional;
import java.util.Vector;
import model.DigestCalculatorItem;
import model.DigestListFileItem;
import model.Status;

/*
 * Responsável por abrir o arquivo de digests, carregá-los em uma lista de DigestListFileItem
 */
public class DigestListFile
{
    private Vector<DigestListFileItem> _digestListFileItems;
    private String _filePath;

    public DigestListFile(String filePath)
    {
        _filePath = filePath;

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(_filePath));
            String line = br.readLine();

            while(line != null)
            {
                line = br.readLine();
                String[] splittedStr = line.split("\\s+");

                DigestListFileItem item = new DigestListFileItem();
                item._name = splittedStr[0];

                byte[] digest = splittedStr[2].getBytes();
                SimpleEntry<String, byte[]> entry = 
                    new SimpleEntry<String, byte[]>(splittedStr[1], digest);
                item._digest1 = entry;

                Optional<SimpleEntry<String, byte[]>> op = Optional.empty(); 
                if(splittedStr.length == 5)
                {
                    digest = splittedStr[4].getBytes();
                    entry = 
                       new SimpleEntry<String, byte[]>(splittedStr[3], digest);
                    op = Optional.of(entry);
                }
                item._digest2 = op;

                _digestListFileItems.add(item);
            }
            br.close();
        }
        catch(Exception e)
        {
			e.printStackTrace();
        }       
    }

    public void updateItemStatus(DigestCalculatorItem item)
    {
        for(DigestListFileItem listItem : _digestListFileItems)
        {
            byte[] digestCalcItem = item._digest.getValue();
            String digestCalcMethod = item._digest.getKey();

            byte[] digestListItem = listItem._digest1.getValue();
            String digestListMethod = listItem._digest1.getKey();

            if(MessageDigest.isEqual(digestCalcItem, digestListItem) &&
               digestCalcMethod.equals(digestListMethod))
            {
                if(!item._name.equals(listItem._name))
                {
                    item._status = Status.COLLISION;
                    return;
                }
                else
                {
                    item._status = Status.OK;
                    return;
                }
            }
            else if(item._name.equals(listItem._name))
            {
                    item._status = Status.NOT_OK;
                    return;
            }
            
            //Segundo digest
            if(!listItem._digest2.isPresent())
            {
                continue;
            }

            digestListItem = listItem._digest2.get().getValue();
            digestListMethod = listItem._digest2.get().getKey();

            if(MessageDigest.isEqual(digestCalcItem, digestListItem) &&
               digestCalcMethod.equals(digestListMethod))
            {
                if(!item._name.equals(listItem._name))
                {
                    item._status = Status.COLLISION;
                    return;
                }
                else
                {
                    item._status = Status.OK;
                    return;
                }
            }
            else
            {
                if(item._name.equals(listItem._name))
                {
                    item._status = Status.NOT_OK;
                    return;
                }
            }
        } 
        
        //Caso o item tenha colidido com algum parâmetro de entrada
        if(item._status == Status.COLLISION)
        {
            return;
        }
    
        item._status = Status.NOT_FOUND;

        for(DigestListFileItem i : _digestListFileItems)
        {
            if(i._name.equals(item._name) && item._status == Status.NOT_FOUND)
            {
                Optional<SimpleEntry<String, byte[]>> op = Optional.empty(); 
                SimpleEntry<String, byte[]> entry = 
                   new SimpleEntry<String, byte[]>(item._digest.getKey(),
                                                   item._digest.getValue());
                op = Optional.of(entry);
                i._digest2 = op;
                return;
            }
        }
        DigestListFileItem newItem = new DigestListFileItem();
        newItem._name = item._name;
        newItem._digest1 = item._digest;
        
        _digestListFileItems.add(newItem);
    }

    //TODO: método que escreve a estrutura de lista de volta para o arquivo
}
