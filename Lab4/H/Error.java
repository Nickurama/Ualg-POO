/**
 * Hold error handling utility for other classes to use
 * 
 * @author Diogo Fonseca a79858
 * @version 21/02/2024
 */
public class Error
{
    /**
     * Terminates execution of the program after printing and error message
     * @param message the message to print before terminating the program
     */
    static void terminateProgram(String message)
    {
        System.out.println(message);
        System.exit(0);
    }
}
