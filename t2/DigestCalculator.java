import controller.DigestListFile;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.AbstractMap.SimpleEntry;
import java.util.Vector;
import model.DigestCalculatorItem;
import model.Status;
import org.apache.commons.io.IOUtils;

@SuppressWarnings("deprecation")

/*
 * Calcula os digests, compara com os que estão
 * no arquivo de digest, e os reexibem no console
 */
public class DigestCalculator
{
	private static Vector<DigestCalculatorItem> _digestCalculatorItems;

	private static String _digestType;
	private static String _digestListFilePath;
	private static Vector<String> _filePaths;

	public static void main(String[] args)
	{
		readInputParameters(args);

		buildDigestCalculatorItems();

		DigestListFile digestListFile = new DigestListFile(_digestListFilePath);

		for(DigestCalculatorItem item : _digestCalculatorItems)
		{
			digestListFile.updateItemStatus(item);
		}

		for(int i = 0; i < _digestCalculatorItems.size(); i++)
		{
			DigestCalculatorItem item1 = _digestCalculatorItems.elementAt(i);
			for(int j = i + 1; j < _digestCalculatorItems.size(); j++)
			{
				DigestCalculatorItem item2 = _digestCalculatorItems.elementAt(j);
				if(item1 == item2)
				{
					continue;
				}
			
				compareAndUpdateStatus(item1, item2);
			}
		}

		//TODO: Método que escreve no console a lista DigestCalculatorItems

		//TODO: chamar método de DigestListFile que escreve a estutura em memória de volta para o arquivo em disco
	}


	private static void readInputParameters(String[] args)
	{
		if(args.length < 3) {
			System.err.println("Usage: DigestCalculator Tipo_Digest<SP>Caminho_Arq1..." +
							   " Caminho_ArqN<SP>Caminho_ArqListaDigest");
			System.exit(1);
		}

		_digestType = args[0];

		for(byte i = 0; i < args.length - 1; i++)
		{
			_filePaths.add(new String(args[i]));
		}

		_digestListFilePath = args[args.length - 1];
	}


	private static void buildDigestCalculatorItems()
	{
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance(_digestType);

			for(String p : _filePaths)
			{
				DigestCalculatorItem item = new DigestCalculatorItem();

				Path path = Paths.get(p);
				item._name = path.getFileName().toString();

				FileInputStream inputStream = new FileInputStream(p);
				String message = IOUtils.toString(inputStream);

				messageDigest.update(message.getBytes(), 0, message.getBytes().length);
				byte[] digest = messageDigest.digest();

				SimpleEntry<String, byte[]> entry =
					new SimpleEntry<String, byte[]>(_digestType, digest);
				item._digest = entry;

				_digestCalculatorItems.add(item);

				inputStream.close();
			}
		}
		catch(Exception e)
		{
			//TODO:
			e.printStackTrace();
		}
	}


	private static void compareAndUpdateStatus(DigestCalculatorItem item1,
											   DigestCalculatorItem item2)
	{
		byte[] digest1 = item1._digest.getValue();
		byte[] digest2 = item2._digest.getValue();
		if(MessageDigest.isEqual(digest1, digest2))
		{
			item1._status = Status.COLLISION;
			item2._status = Status.COLLISION;
		}
	}
}
