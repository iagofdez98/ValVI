package es.uvigo.tfg.valvi.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordToKeyConverter {

    public static byte[] convertPasswordToKey(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        digest.update(salt);
        return digest.digest(password.getBytes());
    }

    public static byte[] generateSalt() {
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password123";
        byte[] salt = generateSalt();
        byte[] key = convertPasswordToKey(password, salt);

        // Convertir la clave en una cadena Base64 para su almacenamiento seguro
        String base64Key = Base64.getEncoder().encodeToString(key);
        System.out.println("Clave generada: " + base64Key);
    }
}
