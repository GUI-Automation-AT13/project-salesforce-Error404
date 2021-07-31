package core.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class EncryptorAES {

    private static final int KEY_ENCRYPTION_LENGTH = 16;

    /**
     * Creates the encryption key to encrypt and decrypt a value.
     *
     * @param key to be used.
     * @return encryption key.
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    private static SecretKeySpec createKey(final String key) throws UnsupportedEncodingException,
            NoSuchAlgorithmException {
        byte[] encryptingKey = key.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        encryptingKey = sha.digest(encryptingKey);
        encryptingKey = Arrays.copyOf(encryptingKey, KEY_ENCRYPTION_LENGTH);
        SecretKeySpec secretKey = new SecretKeySpec(encryptingKey, "AES");
        return secretKey;
    }

    /**
     * Encrypts the text with the given key.
     *
     * @param text              text to encrypt.
     * @param incomingSecretKey key to encrypt.
     * @return Información encriptada.
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String encryptText(final String text, final String incomingSecretKey)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = createKey(incomingSecretKey);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = text.getBytes("UTF-8");
        byte[] encryptedBytes = cipher.doFinal(encryptedData);
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        return encryptedText;
    }

    /**
     * Decrypts the given encrypted text with the encryption key.
     *
     * @param encryptedData     the encrypted data.
     * @param incomingSecretKey encryption key.
     * @return decrypted text.
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws NoSuchPaddingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static String decryptText(final String encryptedData, final String incomingSecretKey)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = createKey(incomingSecretKey);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedData = cipher.doFinal(encryptedBytes);
        String data = new String(decryptedData);
        return data;
    }

    /**
     * Gets the decrypted value.
     *
     * @param incomingText text to decrypt.
     * @param incomingKey  key to decrypt.
     * @return a string with the decrypted text.
     * @throws Exception
     */
    public static String getDecryptedValue(final String incomingText, final String incomingKey) throws Exception {
        String simpleText = "";
        try {
            final String key = incomingKey;
            String text = incomingText;
            EncryptorAES encryptor = new EncryptorAES();
            simpleText = encryptor.decryptText(text, key);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException
                | IllegalBlockSizeException | BadPaddingException ex) {
            System.out.println(ex);
        }
        return simpleText;
    }

}

