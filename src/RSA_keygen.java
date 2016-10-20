import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class RSA_keygen {

	public static void main(String[] args) {

		System.out.println("RSA_keygen version 1.0 build 1");
		System.out.println("by mileu\n");
		
		System.out.println("generating key pair...");
		
		keygen();
		
		System.out.println("key pair saved in document folder");

	}

	public static void keygen() {

		KeyPairGenerator keyPairGenerator;

		try {

			// generate key pair
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(4096);

			KeyPair keyPair = keyPairGenerator.genKeyPair();
			Key publicKey = keyPair.getPublic();
			Key privateKey = keyPair.getPrivate();

			// save keys
			FileOutputStream publicOut = new FileOutputStream(System.getProperty("user.home") + "/Documents/public.key");
			publicOut.write(publicKey.getEncoded());
			publicOut.close();

			FileOutputStream privateOut = new FileOutputStream(System.getProperty("user.home") + "/Documents/private.key");
			privateOut.write(privateKey.getEncoded());
			privateOut.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
