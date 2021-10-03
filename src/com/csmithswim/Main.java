package com.csmithswim;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String mode = "enc";
        String message = "";
        String path = "";
        String alg = "shift";

        int key = 0;
        boolean print = true;
        for (int i = 0; i < args.length; i++) {
            if ("-alg".equalsIgnoreCase(args[i])) {
                alg = args[i + 1];
            }
            else if ("-mode".equalsIgnoreCase(args[i])) {
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

        switch (alg) {
            case "shift":
                if (mode.equalsIgnoreCase("enc")) {
                    Shift.caesarEncrypt(message, key, print, path);
                } else if (mode.equalsIgnoreCase("dec")) {
                    Shift.caesarDecrypt(message, key, print, path);
                }
                break;
            case "unicode":
                if (mode.equalsIgnoreCase("enc")) {
                    Unicode.enc(message, key, print, path);
                } else if (mode.equalsIgnoreCase("dec")) {
                    Unicode.dec(message, key, print, path);
                }
                break;
        }
    }

}










