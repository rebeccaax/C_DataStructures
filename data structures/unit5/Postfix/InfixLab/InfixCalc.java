package unit5.Postfix.InfixLab;
import bca.util.BCAStack;
import unit5.Postfix.*;
import java.util.Scanner;

/**
 * Created by rebeccaxu on 3/5/18.
 */
public class InfixCalc {
    public static void main(String[] args) {
        BCAStack opstack = new BCAStack();
        Scanner input = new Scanner(System.in);
        String output = "";

        System.out.println("Enter a math expression");
        String str = input.nextLine();
        Tokenizer tk = new Tokenizer(str);
        Token t = tk.nextToken();
        Token temp;

        while (t != null) {
            if (t instanceof NumberToken) {
                output += t + " ";
            }
            else if (t instanceof LeftParenToken) {
                opstack.push(t);
            }
            else if (t instanceof RightParenToken) {
                temp = (Token) opstack.pop();
                while (!opstack.isEmpty() && !(temp instanceof LeftParenToken)) {
                    if (temp instanceof OperatorToken) {
                        output += temp + " ";
                    }
                    temp = (Token) opstack.pop();
                }
            }
            else if (t instanceof OperatorToken) {
                int precedence = ((OperatorToken) t).getPrecedence();
                if (!opstack.isEmpty()) {
                    temp = (Token) opstack.peek();

                    while (!opstack.isEmpty() && (temp instanceof OperatorToken &&
                            precedence <= ((OperatorToken) temp).getPrecedence())) {
                        output += opstack.pop() + " ";
                        try {
                            temp = (Token) opstack.peek();
                        }
                        catch (Exception ex) {
                        }
                    }
                }
                opstack.push(t);
            }
            t = tk.nextToken();
        }

            while (!opstack.isEmpty()) {
                temp = (Token) opstack.peek();
                if (temp instanceof OperatorToken) {
                    output += opstack.pop();
                }
            }

            System.out.println(output);
    }
}

//1) Spaces missing between number tokens in output. (-5)

//2) The given test cases work.  The following test case results in an exception:  (-10)

 //       (9*((5 + 2)/3)+1)-14 * 7 + 3 - 6 * 10 / 2