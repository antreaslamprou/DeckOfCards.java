/*
 * Author: Antreas Lamprou (G21070510)
 * Email: ALambrou1@uclan.ac.uk
 * Description: The program prints the floor plan of a student accommodation hall according to the number of students and the type of the room.
 * To compile the program: javac StudentHall.java
 * To run the program: java StudentHall
 */

import java.util.Scanner;

public class StudentHall
{
    public static void main(String[] args)
    {
        int num;
        System.out.print("Number of students staying in Student Accommodation> ");
        Scanner a = new Scanner(System.in); //promts the user for an input
        if (a.hasNextInt() == false) //checks if the user input was number [https://www.studytonight.com/java-examples/check-if-input-is-integer-in-java#:~:text=hasNextInt()%20method%20checks%20whether,otherwise%20it%20will%20return%20false.]
        {
            System.out.print("Please provide a valid input (number) > ");
            Scanner c = new Scanner(System.in);
            num = c.nextInt(); //stores input as num
        }
        else
        {
            num = a.nextInt();
        }
        if (num<1) //checks if input is valid to end the program
        {
            System.exit(0);
        }
        int type;
        System.out.print("Would you like ensuite rooms?" + '\n' + "Please type [1] for Yes or [0] for No: ");
        Scanner b = new Scanner(System.in); //promts the user for input
        if (b.hasNextInt() == false) //checks if the user input is not a number [https://www.studytonight.com/java-examples/check-if-input-is-integer-in-java#:~:text=hasNextInt()%20method%20checks%20whether,otherwise%20it%20will%20return%20false.]
        {
            System.out.print("Please provide a valid input!!\n[1] for Yes or [0] for No: ");
            Scanner d = new Scanner(System.in);
            type = d.nextInt(); //stores input as num
        }
        else
        {
            type = b.nextInt();
        }
        int area ;
        String type1; //create a variable for type giving it one of the two values
        while (type != 0 && type != 1) // checks if input is not 1 or 0
        {
            System.out.print("Please provide a valid input!!\n[1] for Yes or [0] for No: ");
            Scanner d = new Scanner(System.in);
            if (d.hasNextInt() == false) //checks if input is not a number
            {
                System.out.print("Please provide a valid input!!\n[1] for Yes or [0] for No: ");
                Scanner e = new Scanner(System.in);
                type = e.nextInt();
            }
            else
            {
                type = d.nextInt(); //stores input as number
            }
        }
        if (type==0) //checks if the user didnt want ensuite rooms to calculate area
        {
            type1 = "BASIC";
            area = num*9;
        }
        else //if the user did want ensuited rooms
        {
            type1 = "ENSUITE";
            area = num*24;
        }
        System.out.println("The required area to accommodate " + num + " students in " + type1 + " ROOMS is: " + area + " m2" + '\n' + "The floor plan of the Student Hall:");
        String [] ensuitetop = {"| | | | | | |", " | | | | | |", " | | | | | |"}; //creates an array for the top/bot row for ensuite
        String [] ensuitemid = {"|           *", "           *", "           |"}; //creates an array for the mid row for ensuite
        String [] basictop = {"| | | |", " | | |", " | | |"}; //creates an array for the top/bot row for basic
        String [] basicmid = {"|     *", "     *", "     |"}; //creates an array for the mid row for basic
        if (type1=="ENSUITE") //for ensuite rooms
        {
            if (num==1) //checks if one person is staying
            {
                System.out.println("| | | | | | |");
                System.out.println("|           |");
                System.out.println("|           |");
                System.out.println("|           |");
                System.out.println("|           |");
                System.out.println("| | | | | | |");
            }
            else //if its more than 1 person
            {
                for (int i = 1; i <= num; i++) //creates for loop for the top row
                {
                    if (i == 1) // checks if its the first square
                    {
                        System.out.print(ensuitetop[0]);
                    }
                    else if (i == num) //checks if its the last square
                    {
                        System.out.print(ensuitetop[2]);
                    }
                    else //other than those two layers
                    {
                        System.out.print(ensuitetop[1]);
                    }
                }
                for (int j = 0; j < 4; j++) //for loop to print mid rows x4 times
                {
                    System.out.println(); //goes to the next line
                    for (int k = 1; k <= num; k++) // creates for loop for the middle rows
                    {
                        if (k == 1) //checks if its the first square
                        {
                            System.out.print(ensuitemid[0]);
                        }
                        else if (k == num) //checks if its the last square
                        {
                            System.out.print(ensuitemid[2]);
                        }
                        else //other than those two layers
                        {
                            System.out.print(ensuitemid[1]);
                        }
                    }
                }
                System.out.println();
                for (int i = 1; i <= num; i++) { //creates for loop for the bot row
                    if (i == 1) { //checks if its the first square
                        System.out.print(ensuitetop[0]); //applies the first square layout
                    } else if (i == num) { //checks if its the last square
                        System.out.print(ensuitetop[2]); //applies the last square layout
                    } else { //other than those two layers
                        System.out.print(ensuitetop[1]); // applies the middle layout
                    }
                }
            }
        }
        if (type1=="BASIC") //for basic rooms
        {
            if (num==1) //checks if one person is staying
            {
                System.out.println("| | | |");
                System.out.println("|     |");
                System.out.println("|     |");
                System.out.println("|     |");
                System.out.println("| | | |");
            }
            else //if its more than 1 person
            {
                for (int i = 1; i <= num; i++) //creates for loop for the top row
                {
                    if (i == 1) // checks if its the first square
                    {
                        System.out.print(basictop[0]);
                    }
                    else if (i == num) //checks if its the last square
                    {
                        System.out.print(basictop[2]);
                    }
                    else //other than those two layers
                    {
                        System.out.print(basictop[1]);
                    }
                }
                for (int j = 0; j < 3; j++) //for loop to do the middle row x3 times
                {
                    System.out.println();
                    for (int k = 1; k <= num; k++) // creates for loop for the middle rows
                    {
                        if (k == 1) //checks if its the first square
                        {
                            System.out.print(basicmid[0]);
                        }
                        else if (k == num) //checks if its the last square
                        {
                            System.out.print(basicmid[2]);
                        }
                        else //other than those two layers
                        {
                            System.out.print(basicmid[1]);
                        }
                    }
                }
                System.out.println();
                for (int i = 1; i <= num; i++) //creates for loop for the bot row
                {
                    if (i == 1) //checks if its the first square
                    {
                        System.out.print(basictop[0]);
                    }
                    else if (i == num) //checks if its the last square
                    {
                        System.out.print(basictop[2]);
                    }
                    else //other than those two layers
                    {
                        System.out.print(basictop[1]);
                    }
                }
            }
        }
    }
}
