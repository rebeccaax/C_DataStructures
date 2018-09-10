package unit5.Postfix;

/**
 * Created by rebeccaxu on 3/12/18.
 */
public class RightParenToken extends ParenToken {
    public char rightParen = ')';

    public RightParenToken (char op) {
        this.rightParen = op;
    }

    public String toString() {
        return "Right Paren Token: " + rightParen;
    }
}
