package com.csmithswim;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  operation   = scanner.nextLine();
        String message = scanner.nextLine();
        int key = scanner.nextInt();

        switch (operation) {
            case "enc":
                encrypt(message, key);
                break;
            case "dec":
                decrypt(message, key);
                break;
            }
        }

    //decrypts a message based upon a key and includes whitespace and other character's unicode value
    public static String decrypt(String message, int key) {
        String[] userInputArray = message.split("");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                output.append((char)(userInputArray[i].charAt(j) - key));
            }
        }
        System.out.println(output);
        return new String(output);
    }

    //encrypts a message based upon a key and includes whitespace and other character's unicode value
    public static String encrypt(String message, int key) {
        String[] userInputArray = message.split("");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                output.append((char)(userInputArray[i].charAt(j) + key));
            }
        }
        System.out.println(output);
        return new String(output);
    }

    //caesar cypher, reverses a character by key places in unicode, doesn't pay attention to white space or other characters.
    public static String caesarEncrypt(String message, int key) {
        String[] userInputArray = message.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                if (userInputArray[i].charAt(j) < 97 || userInputArray[i].charAt(j) > 122) {
                    output.append(userInputArray[i].charAt(j));
                    continue;
                }
                if (userInputArray[i].charAt(j) + key > 122) {
                    output.append((char)((userInputArray[i].charAt(j) + key - 26)));
                    continue;
                } else {
                output.append((char)(userInputArray[i].charAt(j) + key));
                }
            }
            output.append(" ");
        }
        System.out.println(output);
        return new String(output);
    }

    //encrypt message to reverse english letters, exclude whitespace and other characters
    public static String encryptMessage(String message) {
            String[] userInputArray = message.split(" ");
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < userInputArray.length; i++) {
                for (int j = 0; j < userInputArray[i].length(); j++) {
                    if (userInputArray[i].charAt(j) < 97 || userInputArray[i].charAt(j) > 122) {
                        output.append(userInputArray[i].charAt(j));
                        continue;
                    }
                    char reverseChar = (char)Math.abs((userInputArray[i].charAt(j) - 219));
                    output.append(reverseChar);

                }
                output.append(" ");
            }
            System.out.println(output);
            return new String(output);
    }
}











