/*
 * Author: Antreas Lamprou (G21070510)
 * Email: ALambrou1@uclan.ac.uk
 * Description: The program receives at lunch how many items should be for a list , then the quantities and then the item.
 * To compile the program: javac ShoppingList.java
 * To run the program: java ShoppingList 2 1 6 ham eggs
 */

public class ShoppingList {
    public static void main(String[] args) {
        int count = args.length; // finds the number of arguments [https://stackoverflow.com/questions/11651857/java-101-how-do-i-count-the-number-of-arguments-passed-into-main]
        int n = Integer.parseInt(args[0]);
        if (n <= 0) {
            System.out.println("Please provide a valid number of items");
            System.exit(0);
        }
        String[] a = new String[n]; //creates an array with the size of the first argument (for the number of items)
        String[] b = new String[count - n - 1]; //creates an array with the size of the other arguments (for the items)
        System.out.print("Quantities:");
        int i; // declaration for variable
        for (i = 0; i < n; i++) // for loop to print all the quantities
        {
            a[i] = args[i + 1];
            System.out.print(" " + a[i]);
        }
        System.out.print('\n' + "Items:");
        int l = i + 1;
        for (int j = 0; j < (count - n - 1); j++) // for loop to print all the items
        {
            b[j] = args[l];
            l++;
            System.out.print(" " + b[j]);
        }
        System.out.print('\n' + "My Shopping List:");
        myList(a, b); // executes the function
    }

    static String[] myList(String[] a, String[] b)
    {
        int sizeA = a.length;
        int sizeB = b.length;
        String[] myList = new String[sizeA + sizeB]; // creates the array with the size of items and quantities
        for (int k = 0; k < sizeA; k++) // for loop to print each quantity and item on list
        {
            myList[k] = (a[k] + " " + b[k]);
            System.out.print(" " + myList[k]);
        }
        if (sizeA != sizeB) // checks if items and quantities have the same number
        {
            for (int f = sizeA; f < sizeB; f++) {
                myList[f] = b[f]; // assigns to the array the last items without quantities
                System.out.print(" " + myList[f]);
            }
        }
        return myList;
    }
}

