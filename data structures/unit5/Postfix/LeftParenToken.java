package unit5.Postfix;

/**
 * Created by rebeccaxu on 3/12/18.
 */
public class LeftParenToken extends ParenToken {
    public char leftParen = '(';

    public LeftParenToken (char op) {
        this.leftParen = op;
    }

    public String toString() {
        return "Left Paren Token: " + leftParen;
    }
}
