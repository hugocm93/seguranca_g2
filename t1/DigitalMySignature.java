import java.security.*;
import javax.crypto.*;

public class DigitalMySignature {

public static void main (String[] args) throws Exception {

	// verifica args e recebe o texto plano
	if (args.length !=1) {
		System.err.println("Usage: java DigitalMySignature text");
		System.exit(1);
	}
	byte[] plainText = args[0].getBytes("UTF8");
	
	// gera o par de chaves RSA
	System.out.println( "\nStart generating RSA key" );
	KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
	keyGen.initialize(1024);
	KeyPair key = keyGen.generateKeyPair();
	System.out.println( "Finish generating RSA key" );
	
	// define um objeto signature para utilizar MD5 e RSA
	// e assina o texto plano com a chave privada,
	// o provider utilizado tambem eh impresso
	MySignature sig = MySignature.getInstance("MD5WithRSA");
	sig.initSign(key.getPrivate());
	sig.update(plainText);
	byte[] signature = sig.sign();

	// verifica a assinatura com a chave publica
	System.out.println( "\nStart signature verification" );
	sig.initVerify(key.getPublic());
	sig.update(plainText);
	try {
		if (sig.verify(signature)) {
			System.out.println( "Signature verified" );
		} else System.out.println( "Signature failed" );
	} catch (SignatureException se) {
		System.out.println( "Singature failed" );
	}
}
}


