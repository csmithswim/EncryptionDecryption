package com.csmithswim;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  message   = scanner.nextLine();
        int key = scanner.nextInt();
        Main.encyrptMessage(message, key);

    }

    public static String encyrptMessage(String userInput, int key) {
        String[] userInputArray = userInput.split(" ");
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
    public static String encryptMessage(String userInput) {
            String[] userInputArray = userInput.split(" ");
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











