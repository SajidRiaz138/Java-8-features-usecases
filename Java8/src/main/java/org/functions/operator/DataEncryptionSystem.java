package org.functions.operator;

import org.common.SensitiveData;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class DataEncryptionSystem
{

    public static void main(String[] args)
    {
        List<SensitiveData> sensitiveDataList = Arrays.asList(
                new SensitiveData("1", "password123"),
                new SensitiveData("2", "secretKey456"),
                new SensitiveData("3", "confidential789"));

        // UnaryOperator to encrypt data
        UnaryOperator<String> encrypt = EncryptionUtils::encrypt;

        // UnaryOperator to decrypt data
        UnaryOperator<String> decrypt = EncryptionUtils::decrypt;

        // Encrypt sensitive data
        List<SensitiveData> encryptedDataList = sensitiveDataList.stream()
                .map(data -> new SensitiveData(data.getId(), encrypt.apply(data.getValue())))
                .collect(Collectors.toList());

        System.out.println("Encrypted Data:");
        encryptedDataList.forEach(System.out::println);

        // Decrypt sensitive data
        List<SensitiveData> decryptedDataList = encryptedDataList.stream()
                .map(data -> new SensitiveData(data.getId(), decrypt.apply(data.getValue())))
                .collect(Collectors.toList());

        System.out.println("\nDecrypted Data:");
        decryptedDataList.forEach(System.out::println);
    }
}
