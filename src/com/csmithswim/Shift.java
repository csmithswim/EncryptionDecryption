package com.csmithswim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public abstract class Shift implements Process {

    public static void decrypt(String message, int key, boolean print, String path) {
        String[] userInputArray = message.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                if (userInputArray[i].charAt(j) < 65 || userInputArray[i].charAt(j) > 122) {
                    if (userInputArray[i].charAt(j) > 90 || userInputArray[i].charAt(j) < 97) {
                        output.append((char)(userInputArray[i].charAt(j)));
                        continue;
                    }
                }
                else if (userInputArray[i].charAt(j) - key < 97) {
                    output.append((char)((userInputArray[i].charAt(j) - key + 26)));
                    continue;
                    //Uppercase letter conversion
                } else if (userInputArray[i].charAt(j) - key < 65) {
                    output.append((char)((userInputArray[i].charAt(j) - key + 26)));
                    continue;
                }
                else {
                    output.append((char)(userInputArray[i].charAt(j) - key));
                }
            }
            output.append(" ");
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
        String[] userInputArray = message.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                //chars above or below upper && lower case letters
                if (userInputArray[i].charAt(j) < 65 || userInputArray[i].charAt(j) > 122) {
                    if (userInputArray[i].charAt(j) > 90 || userInputArray[i].charAt(j) < 97) {
                        output.append((char)(userInputArray[i].charAt(j)));
                        continue;
                    }
                }
                else if (userInputArray[i].charAt(j) + key > 122) {
                    output.append((char)((userInputArray[i].charAt(j) + key - 26)));
                    continue;
                } else if (userInputArray[i].charAt(j) < 97 && userInputArray[i].charAt(j) + key > 90) {
                    output.append((char)((userInputArray[i].charAt(j) + key - 26)));
                    continue;
                }
                else {
                    output.append((char)(userInputArray[i].charAt(j) + key));
                }
            }
            output.append(" ");
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
