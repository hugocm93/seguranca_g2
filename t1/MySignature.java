import java.security.PrivateKey;
import java.security.PublicKey;

public class MySignature {

    private static MySignature _md5WithRsa = null;
    private PrivateKey _privateKey;
    private PublicKey _publicKey;

    protected MySignature(){}

    public static MySignature getInstance(String method) {
        switch(method){
            case "MD5WITHRSA":
                if(_md5WithRsa == null) {
                    _md5WithRsa = new MySignature();
                }
                return _md5WithRsa;

            default:
                String message = "Invalid argument for MySignature";
                throw new IllegalArgumentException(message);
        }
    }

	public void initSign(PrivateKey privateKey){
        _privateKey = privateKey;
	}

	public void update(byte[] data){

	}

	public byte[] sign(){
        return null; 
	 }

	public void initVerity(PublicKey publicKey){
        _publicKey = publicKey;
	}

	public boolean verify(byte[] signature){
        return false;
	}
}
