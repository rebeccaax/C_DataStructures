package unit5.PostfixLab;
import bca.util.BCAStack;
import unit5.Postfix.NumberToken;
import unit5.Postfix.OperatorToken;
import unit5.Postfix.Token;
import unit5.Postfix.Tokenizer;
import java.util.Scanner;

/**
 * Created by rebeccaxu on 2/26/18.
 */
public class PostfixCalc {
    public static void main(String[] args) {
        BCAStack stack = new BCAStack();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an expression");
        String str = input.nextLine();
        Tokenizer tk = new Tokenizer(str);
        Token t = tk.nextToken();

        NumberToken num1, num2;
        int pos = 0;
        Token result = t;

        while (t != null) {
            if (t instanceof NumberToken) {
                stack.push(t);
            }

            else if (t instanceof OperatorToken) {
                if (stack.size() < 2) {
                    throw new IndexOutOfBoundsException("Error. There are less than two values.");
                }

                else {
                    num1 = (NumberToken)stack.pop();
                    num2 = (NumberToken)stack.pop();

                    if (((OperatorToken) t).operator == '+') {
                        stack.push (new NumberToken (num1.value + num2.value));
                    }
                    else if (((OperatorToken) t).operator == '-') {
                        stack.push (new NumberToken (num2.value - num1.value));
                    }
                    else if (((OperatorToken) t).operator == '*') {
                        stack.push (new NumberToken (num1.value * num2.value));
                    }
                    else if (((OperatorToken) t).operator == '/') {
                        stack.push (new NumberToken (num2.value / num1.value));
                    }
                }
            }

            else {
               throw new RuntimeException("Runtime Exception: Found " + t  + " expecting an operator at position " + pos);
            }
            pos++;
            t = tk.nextToken();
        }

        if (stack.size() == 1) {
            result = (NumberToken) stack.pop();
            System.out.println("Result: " + ((NumberToken) result).value);
        }

        else if (stack.size() > 1) {
            System.out.println("Error: Not enough operators.");
        }
    }
}


