package org.example.UserInputs;

import java.util.Scanner;

public class ReadInput {

    private static final Scanner stdin = new Scanner(System.in);

    /**(EE)
     * Function that takes in an input prompt (an instruction visible on the console). User enters a string which gets converted into an int.
     * Prevents injection and stops user from entering invalid characters.
     * @param inputPrompt
     * @return Integer entered by user
     */
    public static int readIntFromConsoleWithPrompt(String inputPrompt) {
        do {
            try {
                System.out.printf(inputPrompt);
                return Integer.parseInt(stdin.nextLine());
            } catch (NumberFormatException e) {
                System.out.printf("You entered an invalid character. Please enter a number:\n");
            }
        } while (true);
    }



    /**Method that reads a user input integer from the console.
     * It will print an error message if a non-integer value is entered
     *
     * @return integer from user input
     */
    public static int readIntFromConsoleNoPrompt()
    {
        do
        {
            try
            {
                int num = Integer.parseInt(stdin.nextLine());
                return num;
            }
            catch (NumberFormatException e)
            {
                System.out.printf("The value entered is not valid. Please enter a whole number:");
            }
        } while(true);

    }


    /** Method that reads a user input integer from the console within a set range.
     *  <P>
     *      If the user enters a value outside of the specified range, this will be caught and
     *      the user will receive a message with a user promptMessage (from input parameters) asking them
     *      to re enter a value within the range.
     *  </P>
     *
     * @param rangeMin
     * @param rangeMax
     * @param promptMessage
     * @return integer within the specified range from user input
     */
    public static int readIntFromConsoleInRangeWithPrompt(int rangeMin, int rangeMax, String promptMessage)
    {
        while(true)
        {
            int number = readIntFromConsoleNoPrompt();
            if(number >= rangeMin && number <= rangeMax)
            {
                return number;
            }

            System.out.printf("%s %d and %d.\n", promptMessage, rangeMin, rangeMax);
        }
    }


    /**
     * Method that reads a user input integer from the console within a set range
     * @param rangeMin
     * @param rangeMax
     * @return integer within the specified range from user input
     */
    public static int readIntFromConsoleInRange(int rangeMin, int rangeMax)
    {
        while(true)
        {
            int number = readIntFromConsoleNoPrompt();
            if(number >= rangeMin && number <= rangeMax)
            {
                return number;
            }

            System.out.printf("Please enter a whole number between %d and %d.\n", rangeMin, rangeMax);
        }
    }


}
