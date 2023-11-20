import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;

public class Script {
	public static void main(String[] args) throws Exception
	{
		String plainText = "hello";
		String publicKeyString = "kRa+CqQ8no6sFdBWBVwlyYyTH80FCb+KhmtR80JcifulXJ8Map6uCDlUDG3decu1FlsfPJCzyBFoRWug2PEhIIMg8NkNeGWyTGUxeOO8W+rpHZc8pNkdeVAgGG87dXGBeKiVmSY0Yxl3Q82tT3B10ZBuwmU6054LfLNnuVwtVxyLDMm7MYueTP0EC0+qZjEMrnwF+TsLAKOz8PLHKtZXOM5zPA61q/2lKgM0VN9LLVbROD3Dyr18Bz4v88QdQ+lnNNA3GB13zIIlJ0GMlaKdye9q2OD6anRMRNMYLFjlkWHL961isuEzS9/169YyTrb1BMHjzmD3ihWVzxRG+NvoDQ==";
		String encryptedString = encrypt(publicKeyString, plainText);
		System.out.println(encryptedString);
	}

	public static String encrypt(String publicKeyString, String plainText) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(publicKeyString);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] utf8Bytes = plainText.getBytes("UTF-8");
        return Base64.getEncoder().encodeToString(cipher.doFinal(utf8Bytes));
    }
}