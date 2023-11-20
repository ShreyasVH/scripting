import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Script {
	public static void main(String[] args) throws Exception
	{
		String plainText = "hello";
		String keyString = "ECoXAQ7tesDtU4AfrP2wYA==";
		String ivString = "eu8zIWS3wch/XZzRzOFN3Q==";
		String encryptedString = encrypt(keyString, ivString, plainText);
		System.out.println(encryptedString);
	}

	public static String encrypt(String keyString, String ivString, String plainText) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(keyString);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(Base64.getDecoder().decode(ivString));
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes("UTF-8")));
    }
}