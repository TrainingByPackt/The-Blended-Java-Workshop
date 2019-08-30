package com.packtpub.chapter10;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String algo = "AES";
        try {
            Key privateKey = KeyGenerator.getInstance(algo).generateKey();
            String transform = algo + "/ECB/PKCS5Padding";
            Cipher cipher = Cipher.getInstance(transform);
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            String plaintext = "My super secret message";
            byte[] ciphertext = new byte[cipher.getOutputSize(plaintext.getBytes().length)];
            int encryptedLength = cipher.update(plaintext.getBytes(), 0, plaintext.getBytes().length, ciphertext);

            cipher.doFinal(ciphertext, encryptedLength);

            System.out.println(Arrays.toString(ciphertext));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (ShortBufferException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
