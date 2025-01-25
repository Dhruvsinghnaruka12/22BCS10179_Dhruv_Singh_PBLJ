
package First_Unit;


import java.util.*;


public class Counter {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String abc = sc.nextLine();

        int vowelCounter = 0;
        int consonantCounter = 0;
        int specialCharacterCounter = 0;
        int numberCounter = 0;

        for (int i = 0; i < abc.length(); i++) {
            char ch = abc.charAt(i);

            if (Character.isLetter(ch)) { // Check if the character is a letter
                if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                    ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowelCounter++;
                } else {
                    consonantCounter++;
                }
            } else if (Character.isDigit(ch)) { // Check if the character is a digit
                numberCounter++;
            } else if (!Character.isWhitespace(ch)) { // Check for special characters (excluding spaces)
                specialCharacterCounter++;
            }
        }

        // Display results
        System.out.println("Number of vowels: " + vowelCounter);
        System.out.println("Number of consonants: " + consonantCounter);
        System.out.println("Number of special characters: " + specialCharacterCounter);
        System.out.println("Number of numbers: " + numberCounter);

        sc.close();
    }
}
