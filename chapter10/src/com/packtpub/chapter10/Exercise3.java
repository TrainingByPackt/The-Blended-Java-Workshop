package com.packtpub.chapter10;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Exercise3 {
    public static void main(String[] args) {
        String algo = "AES";
        try {
            Key secretKey = KeyGenerator.getInstance(algo).generateKey();
            String transform = algo + "/CBC/NoPadding";
            Cipher cipher = Cipher.getInstance(transform);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            Path path = Path.of("res/plaintext.txt");
            File plaintext = path.toFile();

            File cipherText = Path.of("res/cipher.txt").toFile();
            if(cipherText.exists())
                cipherText.delete();

            try(FileInputStream fileInputStream = new FileInputStream(plaintext);
                FileOutputStream fileOutputStream = new FileOutputStream(cipherText);
                CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, cipher))
            {
                fileOutputStream.write(cipher.getIV());
                byte[] buffer = new byte[1024];
                int length;
                while((length = fileInputStream.read(buffer)) > 0) {
                    cipherOutputStream.write(buffer, 0, length);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
