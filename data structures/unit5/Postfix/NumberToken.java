package unit5.Postfix;

/**
 * Created by rebeccaxu on 2/22/18.
 */
public class NumberToken extends Token {
    public double value = -1;

    public NumberToken(double value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}
