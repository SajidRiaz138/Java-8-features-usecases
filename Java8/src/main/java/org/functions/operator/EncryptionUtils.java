package org.functions.operator;

import java.util.Base64;

public class EncryptionUtils
{

    // Encrypt the input string
    public static String encrypt(String input)
    {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    // Decrypt the input string
    public static String decrypt(String input)
    {
        return new String(Base64.getDecoder().decode(input));
    }
}
