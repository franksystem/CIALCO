package ec.gob.magap.common.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

import ec.gob.magap.exception.MagapException;

public class Encrypt {

	private static Encrypt INSTANCE = null;
	private Cipher encryptCipher = null;
	private Cipher decryptCipher = null;

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Encrypt();
		}
	}

	public static Encrypt getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	/**
	 * Encrypt a string using DES encryption, and return the encrypted string as
	 * a base64 encoded string.
	 * 
	 * @param unencryptedString
	 *            The string to encrypt.
	 * @return String The DES encrypted and base 64 encoded string.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public String encryptBase64(String unencryptedString) throws MagapException {
		try {
			initialize();
			// Encode the string into bytes using utf-8
			byte[] unencryptedByteArray;
			unencryptedByteArray = unencryptedString.getBytes("UTF8");
			// Encrypt
			byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);

			// Encode bytes to base64 to get a string
			byte[] encodedBytes = Base64.encodeBase64(encryptedBytes);
			return new String(encodedBytes);
		} catch (UnsupportedEncodingException e) {
			MagapLogger.log.error("Encoding" + e);
		} catch (IllegalBlockSizeException e) {
			MagapLogger.log.error("BlockSize" + e);
		} catch (BadPaddingException e) {
			MagapLogger.log.error("BadPadding" + e);
		}
		return null;

	}

	/**
	 * Decrypt a base64 encoded, DES encrypted string and return the unencrypted
	 * string.
	 * 
	 * @param encryptedString
	 *            The base64 encoded string to decrypt.
	 * @return String The decrypted string.
	 * @throws Exception
	 *             If an error occurs.
	 */
	public String decryptBase64(String encryptedString) throws MagapException {
		try {
			initialize();
			// Encode bytes to base64 to get a string
			byte[] decodedBytes = Base64.decodeBase64(encryptedString
					.getBytes());
			// Decrypt
			byte[] unencryptedByteArray;
			unencryptedByteArray = decryptCipher.doFinal(decodedBytes);
			// Decode using utf-8
			return new String(unencryptedByteArray, "UTF8");
		} catch (IllegalBlockSizeException e) {
			MagapLogger.log.error("BlockSize", e);
		} catch (BadPaddingException e) {
			MagapLogger.log.error("BadPadding", e);
		} catch (UnsupportedEncodingException e) {
			MagapLogger.log.error("Encoding", e);
		}
		return null;
	}

	public void initialize() throws MagapException {
		try {
			String password = "Y388QGqAy8OBCjh"; // semilla
			encryptCipher = Cipher.getInstance("DES");
			decryptCipher = Cipher.getInstance("DES");
			DESKeySpec key = new DESKeySpec(password.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			// Instantiate the encrypter/decrypter
			SecretKey secretKey = keyFactory.generateSecret(key);
			encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);
			decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
		} catch (NoSuchAlgorithmException e) {
			MagapLogger.log.error("ErrorInitialize  " + e);
		} catch (NoSuchPaddingException e) {
			MagapLogger.log.error("Error" + e);
		} catch (InvalidKeyException e) {
			MagapLogger.log.error("ErrorKey" + e);
		} catch (InvalidKeySpecException e) {
			MagapLogger.log.error("ErrorSpec" + e);
		}
	}
}