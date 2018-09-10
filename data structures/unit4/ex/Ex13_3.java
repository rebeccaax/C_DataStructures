package unit4.ex;
import java.util.Scanner;
import java.util.Random;

/**
 * Created by rebeccaxu on 1/29/18.
 */
public class Ex13_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] random = new int [100];
        Random rand = new Random();

        for (int i = 0; i < random.length; i++) {
            random[i] = rand.nextInt();
        }

        try {
            System.out.println("Enter an index of the array.");
            int index = input.nextInt();
            System.out.println(random[index]);
        }

        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Enter a number within the range of 100.");
        }

    }
}


//(ArrayIndexOutBoundsException)Writeaprogramthatmeetsthefollowing requirements:
//■ Create an array with 100 randomly chosen integers.
//■ Prompt the user to enter the index of the array, then display the corresponding
// element value. If the specified index is out of bounds, display the message Out of Bounds.