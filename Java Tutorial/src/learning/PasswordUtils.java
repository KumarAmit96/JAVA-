package learning;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

	public static String getCode(String password) throws NoSuchAlgorithmException
	{
	MessageDigest md = MessageDigest.getInstance("SHA-256");
    byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));

	// bytes to hex
    StringBuilder sb = new StringBuilder();
    for (byte b : hashInBytes) {
        sb.append(String.format("%02x", b));
    }
    return sb.toString();
	}
}
