package com.example.springkafkalistdeserializer.utility;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2
@SpringBootTest
public class EncrypterTest {

    @Autowired
    private Encrypter encrypter;

    @Test
    void testMakeKey() {
        try {
            System.out.print("this is key: ");
            String generated = encrypter.generateKey();
            System.out.println(generated);
        } catch (Exception e) {}
    }

    @Test
    void testEncrypt() {
        String plainText = "Hello World";
        try{
            String encrypted = encrypter.encrypt(plainText);
            System.out.println(encrypted);
        } catch (Exception e){}
    }

    @Test
    void testDecrypt() {
        String plainText = "Hello World";
        try {
            String encrypted = encrypter.encrypt(plainText);
            System.out.println(encrypted);
            String decoded = encrypter.decrypt(encrypted);
            System.out.println(decoded);
            assertEquals(plainText, decoded);
        } catch (IllegalArgumentException e) {throw e;}
        catch (Exception e) {}
    }

}
