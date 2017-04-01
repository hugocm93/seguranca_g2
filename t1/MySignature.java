import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;

public class MySignature {

    private static MySignature _md5WithRsa = null;

    private byte[] _data;
    private MessageDigest _messageDigest;
    private Cipher _cipher;

    protected MySignature(String digestMethodName, String encryptionMethodName) throws NoSuchAlgorithmException{
        _messageDigest = MessageDigest.getInstance(digestMethodName);
        _cipher = Cipher.getInstance(encryptionMethodName);
    }

    public static MySignature getInstance(String method) throws IllegalArgumentException {
        switch(method){
            case "MD5WITHRSA":
                if(_md5WithRsa == null) {
                    _md5WithRsa = new MySignature( "MD5", "RSA");
                }
                return _md5WithRsa;

            default:
                String message = "Invalid argument for MySignature";
                throw new IllegalArgumentException(message);
        }
    }

	public void initSign(PrivateKey privateKey){
        _cipher.init(Cipher.ENCRYPT_MODE, privateKey);
	}

	public void update(byte[] data){
        _data = data;
	}

	public byte[] sign(){
        byte[] digest = _messageDigest.digest(_data);

        return _cipher.doFinal(digest);
     }

	public void initVerify(PublicKey publicKey){
	}

	public boolean verify(byte[] signature){
        return false;
	}
}
