import java.security.PrivateKey;
import java.util.Base64;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;

public class Script {
	public static void main(String[] args) throws Exception
	{
		String encryptedText = "cRXemZmvxxuFN+q4DXYsDrJD2iekv4C+reccHqml8MmeNch4tteCMBvgkRiAezicllCg489nRpE5wmD8ER7/nUk4GQzDFQ6mfKiRf3TfQrWiY98gJVDAgvktR6Jv4xr1DdIc/bDnPz2dBrsv6q6mxQJL3km6R8yYtGHA4E8WSQqIVFH8exNI0vALa1msgfU1TenXE6FBM4CpIMx/N1Ji2HCyDTMvg4SK9ot2vjUATK/y6Jk0VRt3COKj9PXkcVMWV/Wu4rmuYOwDms0FTkhkRKl+iHifpJIZw4qjDVF6Kckq0uUPK2gELg++7ASpZuZTNmMvF9rlETdWRNYtx6HlMg==";
		String privateKeyString = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDXXZEAUzTXhvURnKiaxdLVHKuRbjhjgfFrxnBUXTLSaNq2fLXcpe8ZyYvjeR3U0UwDtag1G1AMi5sw9384TwQwImX7+EUIyAsr2GvwPf24KKEXgoClFVe1f7kR1HR+TqPpYRxGBnFmVohJI3yv61LSpEwXfNrkTyPV/GqKw6wRr4/gZ8E0wjXjPuDDdbkPI+GKNzlvjbf83VbN1ulFXXkF27lf2Ir9ay0zE9+A9m3omg4erRZSB70GuzZd6/z9wU5k6zXPGGpCajGuqJXaosOQrWf7PPepVxAWYiBiJzJzXi7AyKCYvvTPCwoXsAwWWRWSshgppYQ6N10jrpiYOZoVAgMBAAECggEAYX9NVo1UncHODlQSjEbEZJAfJ65zPrEj/zuNvNOYX2LyqKyalDJWpSD2AFvjYmYB+KfzZ19fBN7quedBo9c5uSTJcKF7dzdAv2+xpcgapZVXIFKHNLUNyO/yc5zvxAKL9+prp1PhYIgKGLpFB0sMaqnQfM2cNsGRIp2sCff9XN99i+VnY3nDMfhwFt5dS92BmuVK8+L9dUNgab31Ia9wlOqqaTjGvI2ycKi/zfO1znQTaouJ1DhMSOWlZPzAXRM0t56av9rvPgRI+lQV3VBn1GR3n7pIg+Lv++WK3fUTzaq7voea4TvlBjY7NKjfeTOF4s7VzMvTLhj+5ruJ3SLzfQKBgQD+Co8EAaC/DjNMSOCwRbLauzPdVrd16mr7Tzs/iqJGyxKP2IdEwonvkwheqXECw/hh3ZH75DqzXHXGuSyGgVPTR/FuJ28LdnPklIE0/8Ss8IS6+tJ259AyE1HZrL0CfhnbXwOaI29cExwrrPv88WAeI8TeqqLUPI2Q5Q31FgHakwKBgQDZBqrVMlyJuO2RxoSaquO686RjA/t2G8r3dE1pcy2xzt3XjMKt9Zsxv84QaiZpbLK0668LfILwrw+H+HXvodYI33XJOKq3K6yExKczJWpuJYcQLSN2TisEgVray770xL53u04PYaygk5esgqNjPwE9lJe159DgCQRUE88UufoZtwKBgCvhNwLCJTnbAhFTJTxNTa9qVnMM33OGoiP2c41uLMl9mh8uj27ZC2pOQ0vWiKapouWEmAqiSWFhvxYsNfylqgz8iD82oH+iXjJFVGwLIbWddc+2M1RGhjegDqtCowMjNOQnbT/ajwmgY2VH49608p1CIGc1ohp2ux0j8106B+fxAoGBAMpjolqx3YR+FebVSAJpDXjiD9Ja+114q747EpodVGa2MUH7ve221uT9JzE9nNbCDKIWDKbclcvYpdY6idlQhia+JbzigKnTK86hCf/zi55ultcqESEZ4poP++eBDHJ9K9bCsRg9EVyqZ070gWRjdEe2VAjKx4q2PfgehQaiLS9fAoGBAP1mNMiH2Yw2/DRIFQmC5eBEsUfBp2hwWe4pwPBZ6czWyC0qxonlDNdqYK1q1R1KkQsJZsbCIeN0rYuM5ZKPuN4s9j3I1RHK0DyhZQqAoLQkBGaXUESZQWqHTcLdB8YevhIfePRwz5Yskrj2t3rAsCZgfkTHS5sCCCYcDHMw+oQ2";
		String decryptedString = decrypt(privateKeyString, encryptedText);
		System.out.println(decryptedString);
	}

	public static String decrypt(String privateKeyString, String encryptedText) throws Exception {
		byte[] keyBytes = Base64.getDecoder().decode(privateKeyString);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, "UTF-8");
    }
}