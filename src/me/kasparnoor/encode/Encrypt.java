package me.kasparnoor.encrypt;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
    Encrypter created by Kaspar Noor
*/

public class Encrypt {

    // First alphabet
    static char[] alphabet = "fhalxibsecwjkzotrpndygvuqm".toCharArray();
    static String alphabetString = "fhalxibsecwjkzotrpndygvuqm";

    // Second alphabet
    static char[] alphabet2 = "qslmfgrpiuycwntoedbavzjhkx".toCharArray();
    static String alphabet2String = "qslmfgrpiuycwntoedbavzjhkx";

    public static void main(String[] args) {

        /*
         * 
         * 
         * String to be encrypted creation
         * 
         * 
         */

        // Creating a new scanner object for the scanner
        Scanner scanner = new Scanner(System.in);

        // Getting the actual string to be encoded
        System.out.println("Enter the string you want to be encoded.");
        String toEncode = scanner.nextLine();

        scanner.close();

        /*
         * 
         * 
         * ------------------------------
         * 
         * 
         */

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

        // Check for encrypting method conditions
        if (toEncodeFirstLetter == 'a' || toEncodeFirstLetter == 'e' || toEncodeFirstLetter == 'i'
                || toEncodeFirstLetter == 'o' || toEncodeFirstLetter == 'u' || toEncodeFirstLetter == 't'
                || toEncodeFirstLetter == 'c' || toEncodeFirstLetter == 'g' || toEncodeFirstLetter == 't'
                || toEncodeFirstLetter == 'b') {
            System.out.println(firstEncode(toEncode));
        } else {
            System.out.println(secondEncode(toEncode));
        }
    }












    // Encryption method for when the first letter matches first set of conditions
    public static String firstEncode(String toEncode) {
        Random rand = new Random();
        String seperationChar = "[";
        DecimalFormat df = new DecimalFormat("###.###");
        double randomNr = rand.nextInt(99) + 1;
        char toBeEncodedLetter = 'a';
        ArrayList<String> encryptedArray = new ArrayList<>();
        // Encrypting every letter
        for (int i = 0; i < toEncode.length(); i++) {
            // The letter to be encoded
            toBeEncodedLetter = toEncode.charAt(i);

            // EL = encrypted letter
            double posOfEL = toEncode.indexOf(toBeEncodedLetter);
            /*
             * Check the position of the letter to be encoded in the alphabet (if it's in
             * the first or second half)
             */

            double division = posOfEL / randomNr;
            if (posOfEL <= alphabet.length / 2) {
                // Current letter that is being encrypted is in the first half of the alphabet
                String replacementFH;
                replacementFH = df.format(posOfEL / randomNr);
                String replacementFHString = String.valueOf(replacementFH);
                encryptedArray.add(replacementFHString);
            } else {
                // Current letter that is being encrypted is in the second half of the alphabet
                int replacementSH;
                encryptedArray.add(String.valueOf(toBeEncodedLetter));
            }
        }
        String encryptedArrayString = String.join(seperationChar, encryptedArray).replace(".", "-");

        // Random number to alphabet value
        String randomNrCharString = String.valueOf(Math.round(randomNr));
        System.out.println("0: " + randomNr);
        for(int randomIndex = 0; randomIndex < randomNrCharString.length(); randomIndex++) {
            // The character (digit) that is currently being processed in the for loop
            char currentRandomNrDigit = randomNrCharString.charAt(randomIndex);
            // The char in the alphabet
            char indexRandomNrDigitAlphabet = alphabet[Integer.parseInt(String.valueOf(currentRandomNrDigit))];

            System.out.println("1: " + currentRandomNrDigit);
            System.out.println("2: " + indexRandomNrDigitAlphabet);

            randomNrCharString = randomNrCharString.replace(currentRandomNrDigit, indexRandomNrDigitAlphabet);
        }

        // Replace numbers with characters
        int index = 0;
        for(int i = 0; i < encryptedArrayString.length(); i++) {
            // for alphabet
            if(index == 26) { index = 0; };
            if(!isNumeric(String.valueOf(encryptedArrayString.charAt(i)))) { continue; }
            System.out.println(encryptedArrayString.length());
            System.out.println("index: " + i);
            char theCharBeingProcessed = encryptedArrayString.charAt(i);
            char replacementCharFromAlphabet = alphabet[index];
            if(i >= encryptedArrayString.length()) { break; }
            encryptedArrayString = encryptedArrayString.replace(theCharBeingProcessed, replacementCharFromAlphabet);
            index++;
        }

        int randomMethodChooserPlacement = rand.nextInt(encryptedArrayString.length());
        StringBuilder encrypted = new StringBuilder(encryptedArrayString);
        encrypted.insert(randomMethodChooserPlacement, "+");
        encrypted.append("[" + randomNrCharString);
        encrypted.toString();

        return "ENCRYPTED: " + encrypted + "                          random number was " + randomNr + " char string for random nr was " + randomNrCharString;
    }







    // Encryption method for when the first letter matches second set of conditions
    public static String secondEncode(String toEncode) {
        Random rand = new Random();
        String seperationChar = "[";
        DecimalFormat df = new DecimalFormat("###.###");
        double randomNr = rand.nextInt(99) + 1;
        char toBeEncodedLetter = 'a';
        ArrayList<String> encryptedArray = new ArrayList<>();
        // Encrypting every letter
        for (int i = 0; i < toEncode.length(); i++) {
            // The letter to be encoded
            toBeEncodedLetter = toEncode.charAt(i);

            // EL = encrypted letter
            double posOfEL = toEncode.indexOf(toBeEncodedLetter);
            /*
             * Check the position of the letter to be encoded in the alphabet (if it's in
             * the first or second half)
             */

            double division = posOfEL / randomNr;
            if (posOfEL <= alphabet2.length / 2) {
                // Current letter that is being encrypted is in the first half of the alphabet
                String replacementFH;
                replacementFH = df.format(posOfEL / randomNr);
                String replacementFHString = String.valueOf(replacementFH);
                encryptedArray.add(replacementFHString);
            } else {
                // Current letter that is being encrypted is in the second half of the alphabet
                int replacementSH;
                encryptedArray.add(String.valueOf(toBeEncodedLetter));
            }
        }
        String encryptedArrayString = String.join(seperationChar, encryptedArray).replace(".", "-");

        // Random number to alphabet value
        String randomNrCharString = String.valueOf(Math.round(randomNr));
        System.out.println("0: " + randomNr);
        for(int randomIndex = 0; randomIndex < randomNrCharString.length(); randomIndex++) {
            // The character (digit) that is currently being processed in the for loop
            char currentRandomNrDigit = randomNrCharString.charAt(randomIndex);
            // The char in the alphabet
            char indexRandomNrDigitAlphabet = alphabet2[Integer.parseInt(String.valueOf(currentRandomNrDigit))];

            System.out.println("1: " + currentRandomNrDigit);
            System.out.println("2: " + indexRandomNrDigitAlphabet);

            randomNrCharString = randomNrCharString.replace(currentRandomNrDigit, indexRandomNrDigitAlphabet);
        }

        // Replace numbers with characters
        int index = 0;
        for(int i = 0; i < encryptedArrayString.length(); i++) {
            // for alphabet
            if(index == 26) { index = 0; };
            if(!isNumeric(String.valueOf(encryptedArrayString.charAt(i)))) { continue; }
            System.out.println(encryptedArrayString.length());
            System.out.println("index: " + i);
            char theCharBeingProcessed = encryptedArrayString.charAt(i);
            char replacementCharFromAlphabet = alphabet2[index];
            if(i >= encryptedArrayString.length()) { break; }
            encryptedArrayString = encryptedArrayString.replace(theCharBeingProcessed, replacementCharFromAlphabet);
            index++;
        }

        int randomMethodChooserPlacement = rand.nextInt(encryptedArrayString.length());
        StringBuilder encrypted = new StringBuilder(encryptedArrayString);
        encrypted.insert(randomMethodChooserPlacement, "++");
        encrypted.append("[" + randomNrCharString);
        encrypted.toString();

        return "ENCRYPTED: " + encrypted + "                          random number was " + randomNr + " char string for random nr was " + randomNrCharString;
    }


    // Utility for checking if String is a number
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }



}