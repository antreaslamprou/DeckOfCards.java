/*
 * Author: Antreas Lamprou (G21070510)
 * Email: ALambrou1@uclan.ac.uk
 * Description: The program converts a number into text.
 * To compile the program: javac NumToText.java
 * To run the program: java NumToText 1
 */

public class NumToText {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]); //makes the user to input an integer number for input
        int num1 = 0; // used later for two decimal numbers
        String [] units = {"", "One", "To", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"}; //create array for units
        String [] decades = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}; //create array for decates
        if (num<-100 || num>100){ //add the maximum and minimum
            System.out.println("Number out of bounds. Please provide a number between -100 and 100");
            System.exit(0); //ends the program [https://www.geeksforgeeks.org/system-exit-in-java/#:~:text=exit()%20method%20exits%20current,method%20takes%20a%20status%20code]
        } else {
            System.out.println(num); //returns the number to the user
        } if (num == 0) { //checks if number is zero
            System.out.print("Zero");
        } else if (num == 100 || num == -100) { //checks if number is One Hundred
            if (num<0) { //checks if number is negative
                System.out.print("Minus ");
            }System.out.print("One Hundred");
        } else if (num>-10 && num<10) { //checks if number is one decimal
            if (num < 0) { //checks if number is minus
                System.out.print("Minus ");
                num = -num; //makes the number positive for the arrays
            }System.out.print(units[num]);
        } else if (num == 11 || num == -11) {
            if (num < 0) { //checks if number is minus
                System.out.print("Minus ");
                num = -num; //makes the number positive for the arrays
            }System.out.println("Eleven");
        } else if (num == 12 || num == -12) {
            if (num < 0) { //checks if number is minus
                System.out.print("Minus ");
                num = -num; //makes the number positive for the arrays
            }System.out.println("Twelve");
        } else if (num == 13 || num == -13) {
            if (num < 0) { //checks if number is minus
                System.out.print("Minus ");
                num = -num; //makes the number positive for the arrays
            }System.out.println("Thirteen");
        } else if ((num >= 14 && num<20) || (num <= 14 && num > -20)) {
            if (num < 0) { //checks if number is minus
                System.out.print("Minus ");
                num = -num; //makes the number positive for the arrays
            } num = num%10;
            System.out.println(units[num] + "teen");
        } else if (num <= -20 || num >=-20) { //checks if number is two decimals
            if (num < 0) { //checks if number is minus
                System.out.print("Minus ");
                num = -num; //makes the number positive for the arrays
            } int num2 = num/10; //finds the decades
            while (num > 10) {
                num = num%10; //finds the units
            } System.out.print(decades[num2] + " " + units[num]);
        }
    }
}
