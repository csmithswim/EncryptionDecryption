package com.csmithswim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EncryptionDecryption  {

    //Method to read command line arguments and store them in fields(constructor?)
    //String[] input/args
    //Iterate through whole array
    //Params begin with -
    //Arguments are params + 1

    //java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode

    //Two different subclasses and their overridden methods to encrypt or decrypt Args
    //java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode

    //Field declarations
    private String  message;
    private String path;
    private String algorithm;
    private String mode;
    private int     key;
    private boolean print;

    private Process process;

    //Constructor with default values
    public EncryptionDecryption() {
        message = "";
        path      = "";
        algorithm = "shift";
        mode      = "";
        key     = 0;
        print   = true;
    }

    public void setProcess(Process process) {
        this.process = process;
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













