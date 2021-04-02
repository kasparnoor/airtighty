package me.kasparnoor.encode;

import java.util.Scanner;

/*
    Encrypter created by Kaspar Noor
*/

public class Encode {

    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {

        // Creating a new scanner object for the scanner
        Scanner scanner = new Scanner(System.in);

        // Getting the actual string to be encoded
        System.out.println("Enter the string you want to be encoded.");
        String toEncode = scanner.nextLine();

        /*
         * Choosing the encryption type based on if the first letter in the string is a
         * vowel or a consonant
         */
        char toEncodeFirstLetter = 'a';
        for (char c : toEncode.toCharArray()) {
            if (Character.isLetter(c)) {
                toEncodeFirstLetter = c;
                break;
            }
        }

        if (toEncodeFirstLetter == 'a' || toEncodeFirstLetter == 'e' || toEncodeFirstLetter == 'i'
                || toEncodeFirstLetter == 'o' || toEncodeFirstLetter == 'u' || toEncodeFirstLetter == 't'
                || toEncodeFirstLetter == 'c' || toEncodeFirstLetter == 'g' || toEncodeFirstLetter == 't'
                || toEncodeFirstLetter == 'b') {
            System.out.println("first");
            vowelEncode(toEncode);
        } else {
            System.out.println("second");
            consonantEncode(toEncode);
        }
    }

    public static void vowelEncode(String toEncode) {
        char toBeEncodedLetter = 'a';
        for (int i = 0; i < toEncode.length(); i++) {
            toBeEncodedLetter = toEncode.charAt(i);
        }
    }

    public static void consonantEncode(String toEncode) {
        char toBeEncodedLetter = 'a';
        for (int i = 0; i < toEncode.length(); i++) {
            toBeEncodedLetter = toEncode.charAt(i);
        }
    }
}