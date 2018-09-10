package unit5.Postfix;

/**
 * Created by rebeccaxu on 2/22/18.
 */
public class OperatorToken extends Token {
    public char operator = ' ';

    public OperatorToken (char op) {
        this.operator = op;
    }

    public int getPrecedence() {
        if (operator == '*' || operator == '/') {
            return 2;
        }
        else if (operator == '+' || operator == '-') {
            return 1;
        }
        else {
            throw new RuntimeException("Unexpected Operator");
        }
    }

    public String toString() {
        return "" + operator;
    }
}
