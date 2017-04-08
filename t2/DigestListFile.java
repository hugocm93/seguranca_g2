package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.StringBuilder;
import java.security.MessageDigest;
import java.util.AbstractMap.SimpleEntry;
import java.util.Optional;
import java.util.Vector;
import model.DigestCalculatorItem;
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

        BufferedReader br = new BufferedReader(new FileReader(_filePath));
        try
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while(line != null)
            {
                line = br.readLine();
                String[] splittedStr = br.split("\\s+");

                DigestListFileItem item = new DigestListFileItem();
                item._name = splittedStr[0];

                byte[] digest = Integer.decode(splittedStr[2];
                SimpleEntry<String, byte[]> entry = 
                    new SimpleEntry<String, byte[]>(splittedStr[1], digest);
                item._digest1 = entry;

                Optional<SimpleEntry<String, byte[]>> op = Optional.empty(); 
                if(splittedStr.length() == 5)
                {
                    digest = Integer.decode(splittedStr[4];
                    entry = 
                       new SimpleEntry<String, byte[]>(splittedStr[3], digest);
                    op = Optional.of(entry);
                }
                item._digest2 = op;

                _digestListFileItems.add(item);
            }
        }
        finally
        {
            br.close();
        }       
    }

    private void updateItemStatus(DigestCalculatorItem item)
    {
        for(DigestListFileItem listItem : _digestListFileItems)
        {
            byte[] digestCalcItem = item._digest.getValue();
            String digestCalcMethod = item._digest.getKey();

            byte[] digestListItem = listItem._digest1.getValue();
            String digestListMethod = item._digest1.getKey();

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
                if(!item._name.equals(listItem._name))
                {
                    continue;
                }
                else
                {
                    item._status = Status.NOT_OK;
                    return;
                }
            }
        } 
        item._status = Status.NOT_FOUND;
        //TODO: add na lista _digestListFileItems
        //TODO: verificar o segundo digest
    }
    //TODO: Método que recebe um DigestCalculatorItem,
    // atualiza seu status, e o adiciona na lista de
    // DigestListFileItem se ele não estiver lá

    //TODO: método que escreve a estrutura de lista de volta para o arquivo
}
