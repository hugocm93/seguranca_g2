import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class MySignature {

    private static MySignature _md5WithRsa = null;

    private byte[] _data;
    private MessageDigest _messageDigest;
    private Cipher _cipher;

    protected MySignature(String digestMethodName, String encryptionMethodName) 
                throws NoSuchAlgorithmException, NoSuchPaddingException{
        _messageDigest = MessageDigest.getInstance(digestMethodName);
        _cipher = Cipher.getInstance(encryptionMethodName);
    }

    public static MySignature getInstance(String method) throws IllegalArgumentException, NoSuchAlgorithmException, NoSuchPaddingException{
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

	public void initSign(PrivateKey privateKey) throws InvalidKeyException{
        _cipher.init(Cipher.ENCRYPT_MODE, privateKey);
	}

	public void update(byte[] data){
        _data = data;
	}

	public byte[] sign() throws IllegalBlockSizeException, BadPaddingException {
        byte[] digest = _messageDigest.digest(_data);

        return _cipher.doFinal(digest);
     }

    public void initVerify(PublicKey publicKey) throws InvalidKeyException{
		_cipher.init(Cipher.DECRYPT_MODE, publicKey);
    }

    public boolean verify(byte[] signature) throws SignatureException{
	    byte messageDigestPublic[] = null;
	    try {
	        messageDigestPublic = _messageDigest.digest();
	    } catch (NullPointerException npe) {
			throw new SignatureException("No SHA digest found");
	    }

	    byte[] messageDigestPrivate = null;
	    try{
			messageDigestPrivate = _cipher.doFinal(signature);
	    } 
		catch (Exception e){
			throw new Exception("Fail to get messageDigestPrivate");
	    } 
		finally{
			return MessageDigest.isEqual(messageDigestPrivate, messageDigestPublic);
		}
	}
}
