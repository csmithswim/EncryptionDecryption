package com.csmithswim;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Shift {


    public static void caesarDecrypt(String message, int key, boolean print, String path) {
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
                //A - Z 65 - 90
                //a - z 97 - 122
                //for lowercase letter circles
                else if (userInputArray[i].charAt(j) - key < 97) {
                    output.append((char)((userInputArray[i].charAt(j) - key + 26)));
                    continue;
                    //for uppercase letters circle
                } else if (userInputArray[i].charAt(j) - key < 65) {
                    output.append((char)((userInputArray[i].charAt(j) - key + 26)));
                    continue;
                }
                //all other cases to shift letters
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

    //caesar cypher, reverses a character by key places in unicode, doesn't pay attention to white space or other characters.
    public static void caesarEncrypt(String message, int key, boolean print, String path) {
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
                //for lowercase letters circle
                else if (userInputArray[i].charAt(j) + key > 122) {
                    output.append((char)((userInputArray[i].charAt(j) + key - 26)));
                    continue;
                    //for uppercase letters circle
                } else if (userInputArray[i].charAt(j) < 97 && userInputArray[i].charAt(j) + key > 90) {
                    output.append((char)((userInputArray[i].charAt(j) + key - 26)));
                    continue;
                }
                //all other cases to shift letters
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

    //encrypt message to reverse english letters, exclude whitespace and other characters

//    public static String encryptMessage(String message) {
//        String[] userInputArray = message.split(" ");
//        StringBuilder output = new StringBuilder();
//        for (int i = 0; i < userInputArray.length; i++) {
//            for (int j = 0; j < userInputArray[i].length(); j++) {
//                if (userInputArray[i].charAt(j) < 97 || userInputArray[i].charAt(j) > 122) {
//                    output.append(userInputArray[i].charAt(j));
//                    continue;
//                }
//                char reverseChar = (char)Math.abs((userInputArray[i].charAt(j) - 219));
//                output.append(reverseChar);
//
//            }
//            output.append(" ");
//        }
//        System.out.println(output);
//        return new String(output);
//    }
}
