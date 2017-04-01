import java.security.PrivateKey;
import java.security.PublicKey;

public class MySignature {

    private PrivateKey _privateKey;
    private PublicKey _publicKey;

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
