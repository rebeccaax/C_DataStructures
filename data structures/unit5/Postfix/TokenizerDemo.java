package unit5.Postfix;

import java.util.Scanner;

/**
 * Created by rebeccaxu on 2/26/18.
 */
public class TokenizerDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string.");
        String str = in.nextLine();

        Tokenizer tk = new Tokenizer(str);
        Token t = tk.nextToken();
        while (t != null) {
            System.out.println(t);

            if (t instanceof NumberToken) {
                NumberToken nt = (NumberToken)t;
                System.out.println("It's a number token");
                System.out.println(nt.value);
            }

            else if ( t instanceof OperatorToken) {
                System.out.println("It's an operator token.");
            }

            t = tk.nextToken();
        }
    }
}
