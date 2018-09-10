package unit4.ex;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by rebeccaxu on 1/29/18.
 */
public class Ex13_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum;
        while (true) {
            try {
                System.out.println("Enter the first number.");
                int num1 = input.nextInt();
                System.out.println("Enter the second number.");
                int num2 = input.nextInt();
                sum = num1+num2;
                System.out.println(sum);
                return;

            }

            catch (InputMismatchException ex) {
                System.out.println("Please only enter numbers");
                input.nextLine();
            }
        }
    }
}

// (NumberFormatException)
// Write a program that prompts the user to read two integers
// and displays their sum. Your program should prompt the user
// to read the number again if the input is incorrect.