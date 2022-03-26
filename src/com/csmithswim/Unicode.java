package com.csmithswim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Unicode {

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
}
