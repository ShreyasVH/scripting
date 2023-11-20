import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Script {
	public static void main(String[] args) throws Exception
	{
		String encryptedText = "EUClgiBEn1kQCRIIe6EVAA==";
		String keyString = "ECoXAQ7tesDtU4AfrP2wYA==";
		String ivString = "eu8zIWS3wch/XZzRzOFN3Q==";
		String decryptedString = decrypt(keyString, ivString, encryptedText);
		System.out.println(decryptedString);
	}

	public static String decrypt(String keyString, String ivString, String encryptedText) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(keyString);
		
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(Base64.getDecoder().decode(ivString));
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }
}