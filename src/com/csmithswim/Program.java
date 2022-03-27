package com.csmithswim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

    private String  message;
    private String  path;
    private String  algorithm;
    private String  mode;
    private int     key;
    private boolean print;

    private Process process;

    //Default constructor
    public Program() {
        message   = "";
        path      = "";
        algorithm = "shift";
        mode      = "";
        key       = 0;
        print     = true;
    }

    public String[] standardInput() {
        System.out.print("Enter String[] Arguments:");
        Scanner scanner = new Scanner(System.in);
        String[] rawInputArray = scanner.nextLine().split("\\s(?=(?:[^'\"`]*(['\"`])[^'\"`]*\\1)*[^'\"`]*$)");
        return rawInputArray;
    }

    public void processInputs(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if ("-alg".equalsIgnoreCase(input[i])) {
                algorithm = input[i + 1];
            } else if ("-mode".equalsIgnoreCase(input[i])) {
                mode = input[i + 1];
            } else if ("-key".equalsIgnoreCase(input[i])) {
                key = Integer.parseInt(input[i + 1]);
            } else if ("-data".equalsIgnoreCase(input[i])) {
                message = input[i + 1];
            } else if ("-in".equalsIgnoreCase(input[i])) {
                File file = new File(input[i + 1]);
                try (Scanner scanner = new Scanner(file)) {
                    message = scanner.nextLine();
                } catch (FileNotFoundException e) {
                    System.out.println("No file found");
                }
            } else if ("-out".equalsIgnoreCase(input[i])) {
                path  = input[i + 1];
                print = false;
            }
        }

        switch (algorithm) {
            case "shift":
                if (mode.equalsIgnoreCase("enc")) {
                    Shift.encrypt(message, key, print, path);
                } else if (mode.equalsIgnoreCase("dec")) {
                    Shift.decrypt(message, key, print, path);
                }
                break;
            case "unicode":
                if (mode.equalsIgnoreCase("enc")) {
                    Unicode.encrypt(message, key, print, path);
                } else if (mode.equalsIgnoreCase("dec")) {
                    Unicode.decrypt(message, key, print, path);
                }
                break;
        }
    }
}















