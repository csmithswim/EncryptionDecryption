package com.csmithswim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public abstract class Shift implements Process {

    public static void decrypt(String message, int key, boolean print, String path) {
        String[] userInputArray = message.split(" ");
        StringBuilder output = new StringBuilder();
        int shift = key % 26;
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                //Checking for special characters and white space.
                if (userInputArray[i].charAt(j) < 65 || userInputArray[i].charAt(j) > 122) {
                    if (userInputArray[i].charAt(j) > 90 || userInputArray[i].charAt(j) < 97) {
                        output.append((char)(userInputArray[i].charAt(j)));
                        continue;
                    }
                }
                //Checking if lowercase character shifts beyond 'a' (97) on ascii chart
                else if (userInputArray[i].charAt(j)  < 97) {
                    output.append((char)((userInputArray[i].charAt(j) - shift + 26)));
                    continue;

                //for uppercase letters circle
                } else if (userInputArray[i].charAt(j) - shift < 65) {
                    output.append((char)((userInputArray[i].charAt(j) - shift + 26)));
                    continue;
                }
                else {
                    output.append((char)(userInputArray[i].charAt(j) - shift));
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
        int shift = key % 26;
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                //Checking for special characters
                if (userInputArray[i].charAt(j) < 65 || userInputArray[i].charAt(j) > 122) {
                    if (userInputArray[i].charAt(j) > 90 || userInputArray[i].charAt(j) < 97) {
                        output.append((char)(userInputArray[i].charAt(j)));
                        continue;
                    }
                }

                //Checking if encrypted char is above z (122)
                else if (userInputArray[i].charAt(j) + shift > 122) {
                    output.append((char)((userInputArray[i].charAt(j) + shift - 26)));
                    continue;
                //a - z
                //97 - 122
                //A - Z
                //65 - 90

                //checking if encrypted char + key is A - Z
                } else if (userInputArray[i].charAt(j) < 97 && userInputArray[i].charAt(j) + shift > 90) {
                    output.append((char)((userInputArray[i].charAt(j) + shift - 26)));
                    continue;
                }
                else {
                    //encrypted char + the key is within the ascii range of a - z || A - Z
                    output.append((char)(userInputArray[i].charAt(j) + shift));
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
