package com.csmithswim;
import java.util.Scanner;
/*For the first stage, you need to manually encrypt the message "we found a treasure!" and print only the ciphertext (in lower case).
To encrypt the message, replace each letter with the letter that is in the corresponding position from the end of the English alphabet (a→z, b→y, c→x, ... x→c, y →b, z→a). Do not replace spaces or the exclamation mark.
Use the given template to your program to print the ciphertext instead of the original message.
The output should look like ## ##### # ########! where # is a lower-case English letter.*/
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Main.encryptMessage(input);

    }


        public static String encryptMessage(String userInput) {
            String[] userInputStringArray = userInput.split(" ");
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < userInputStringArray.length; i++) {
                for (int j = 0; j < userInputStringArray[i].length(); j++) {
                    if (userInputStringArray[i].charAt(j) < 97 || userInputStringArray[i].charAt(j) > 122) {
                        output.append(userInputStringArray[i].charAt(j));
                        continue;
                    }
                    char reverseChar = (char)Math.abs((userInputStringArray[i].charAt(j) - 97) - 122);
                    output.append(reverseChar);

                }
                output.append(" ");
            }
            System.out.println(output);
            return new String(output);
        }
}





