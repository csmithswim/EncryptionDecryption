package com.csmithswim;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        //TRY {
        //IF args == -in
        //READ file as a String[]
        //ELSE IF args == -out
        //WRITE file as a String
        //other cases

        String mode = "enc";
        String message = "";
        String path = "";
        int key = 0;
        boolean print = true;
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equalsIgnoreCase(args[i])) {
                mode = args[i + 1];
            } else if ("-key".equalsIgnoreCase(args[i])) {
                key = Integer.parseInt(args[i + 1]);
            } else if ("-data".equalsIgnoreCase(args[i])) {
                message = args[i + 1];
            } else if ("-in".equalsIgnoreCase(args[i])) {
                File file = new File(args[i + 1]);
                try (Scanner scanner = new Scanner(file)) {
                    message = scanner.nextLine();
                } catch (FileNotFoundException e) {
                    System.out.println("No file found");
                }
            } else if ("-out".equalsIgnoreCase(args[i])) {
                path = args[i + 1];
                print = false;
            }
        }

        switch (mode) {
            case "enc":
                encrypt(message, key, print, path);
                break;
            case "dec":
                decrypt(message, key, print, path);
                break;
        }
    }

    //decrypts a message based upon a key and includes whitespace and other character's unicode value
    public static void decrypt(String message, int key, boolean print, String path) {
        String[] userInputArray = message.split("");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                output.append((char) (userInputArray[i].charAt(j) - key));
            }
        }
        if (print) {
            System.out.println(output);
        } else {
            File file = new File(path);
            try (FileWriter writer = new FileWriter(path)) {
                writer.write(new String(output));
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }
        }
    }

    //encrypts a message based upon a key and includes whitespace and other character's unicode value
    public static void encrypt(String message, int key, boolean print, String path) {
        String[] userInputArray = message.split("");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                output.append((char) (userInputArray[i].charAt(j) + key));
            }
        }
        if (print) {
            System.out.println(output);
        } else {
            File file = new File(path);
            try (FileWriter writer = new FileWriter(path)) {
                writer.write(new String(output));
            } catch (IOException e) {
                System.out.printf("An exception occurs %s", e.getMessage());
            }
        }
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






