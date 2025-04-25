/*
 * Author: Antreas Lamprou (G21070510)
 * Email: ALambrou1@uclan.ac.uk
 * Description: The program converts seconds into seconds, minutes and hours (max 1 day).
 * To compile the program: javac TimeTranslator.java
 * To run the program: java TimeTranslator
 */

/**
 * Results Of The Program:
 * PS C:\Users\User\IdeaProjects\Alambrou1_CO1407\src> javac TimeTranslator.java
 * PS C:\Users\User\IdeaProjects\Alambrou1_CO1407\src> java TimeTranslator
 * Enter number of seconds: 3600
 * 1 hour exactly!
 * Enter number of seconds: 60
 * 1 minute exactly!
 * Enter number of seconds: 1
 * 1 second
 * Enter number of seconds: 99999
 * The value you entered is longer than a day! Try a smaller value.
 * Enter number of seconds: 86400
 * FULL DAY!
 * Enter number of seconds: 3696
 * 36 seconds, 1 minute, 1 hour
 * Enter number of seconds: 3660
 * 1 minute, 1 hour
 * Enter number of seconds: 3661
 * 1 second, 1 minute, 1 hour
 * Enter number of seconds: 3602
 * 2 seconds, 1 hour
 * Enter number of seconds: 0
 * PS C:\Users\User\IdeaProjects\Alambrou1_CO1407\src>
 * >I used all single and explicit seconds which gave back one number only with the "exactly!" indication.
 * >I used the full day seconds .
 * >Used a value over the limit to check the max error message.
 * Tried some different values to check that if we have single value of mins/hrs/secs they wont be in plural.
 * >Tried some different values to check that if we dont have a min/hrs/secs they wont be displayed.
 * >0 was tested so that the program ends and you can exit.
 **/

import java.util.Scanner;

public class TimeTranslator
{
    public static void main(String[] args)
    {
        String[] single = {"second", "minute", "hour"}; // for single values
        String[] plural = {"seconds", "minutes", "hours"}; // for plural values
        String secs = "";
        String mins = "";
        String hrs = "";
        int num; // will be used later as input value
        while (true)
        {
            System.out.print("Enter number of seconds: "); //prints this message to the user
            Scanner a = new Scanner(System.in); //promts the user to write a value
            if (a.hasNextInt() == false)
            {
                System.out.print("Please enter a VALID NUMBER of seconds: ");
                Scanner b = new Scanner(System.in);
                num = b.nextInt();
                if (num ==0) System.exit(0);
            }
            else num = a.nextInt(); //stores user value as variable "sec"
            if (num<0) // checks if user used a negative value
            {
                System.out.println("Please enter a VALID NUMBER of secons: ");
                Scanner b = new Scanner(System.in);
                num = b.nextInt();
                if (num ==0) System.exit(0);
            }
            while (num > 86400) //promts the user over and over again till a valid input comes
            {
                System.out.println("The value you entered is longer than a day! Try a smaller value.");
                System.out.print("Enter number of seconds: "); //prints this message to the user
                Scanner b = new Scanner(System.in); //promts the user to write a value
                num = b.nextInt(); //stores user value as variable "sec"
            }
            if (num == 0)
            {
                System.exit(0); //exits the program
            }
            else if (num == 86400) //checks if its full day
            {
                System.out.println("FULL DAY!"); //prints out full day
            }
            else
            {
                int numhr = num / 3600; //finds how many hours
                if (numhr == 1) //checks if its one hour
                {
                    hrs = numhr + " " + single[2]; //applies single array
                }
                else
                {
                    hrs = numhr + " " + plural[2]; //applies plural array
                }
                int nummin = 0;
                nummin = (num % 3600) / 60; // finds minutes (excluding hrs)
                if (nummin == 1) //checks if its one minute
                {
                    mins = nummin + " " + single[1]; //applies single array
                }
                else
                {
                    mins = nummin + " " + plural[1]; //applies plural array
                }
                int numsec = (num % 3600) % 60; // finds the seconds (excluding hrs and mins)
                if (numsec == 1)
                {
                    secs = numsec + " " + single[0]; //applies single array
                }
                else
                {
                    secs = numsec + " " + plural[0]; //applies plural array
                }
                if (numhr == 0) //checks if hours are zero
                {
                    if (nummin == 0) //checks if minutes are zero
                    {
                        System.out.println(secs );
                    }
                    else if (numsec == 0)
                    {
                        System.out.println(mins + " exactly!");
                    }
                    else
                    {
                        System.out.println(secs + ", " + mins);
                    }
                }
                else if (nummin == 0) //checks if minutes are zero
                {
                    if (numsec == 0) //checks if seconds are zero
                    {
                        System.out.println(hrs + " exactly!");
                    }
                    else
                    {
                        System.out.println(secs + ", " + hrs);
                    }
                }
                else if (numsec == 0) //checks if seconds are zero
                {
                    System.out.println(mins + ", " + hrs);
                }
                else
                {
                    System.out.println(secs + ", " + mins + ", " + hrs);
                }
            }
        }
    }
}