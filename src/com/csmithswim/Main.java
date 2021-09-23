package com.csmithswim;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  message   = scanner.nextLine();
        int key = scanner.nextInt();
        Main.encyrptMessage(message, key);

    }

    //97 - 122 is a - z
    //Find how to shift the char int key places when char + key > 122

    public static String encyrptMessage(String userInput, int key) {
        String[] userInputArray = userInput.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < userInputArray.length; i++) {
            for (int j = 0; j < userInputArray[i].length(); j++) {
                if (userInputArray[i].charAt(j) < 97 || userInputArray[i].charAt(j) > 122) {
                    output.append(userInputArray[i].charAt(j));
                    continue;
                }
                output.append((char)Math.abs((userInputArray[i].charAt(j) - 219)));
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











