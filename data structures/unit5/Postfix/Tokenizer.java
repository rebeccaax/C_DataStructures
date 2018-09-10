package unit5.Postfix;

/**
 * Created by rebeccaxu on 2/26/18.
 */
public class Tokenizer {
    private char[] tokenStr = null;
    int pos = 0;

    public Tokenizer (String str) {
        tokenStr = str.toCharArray();
    }


    private NumberToken readNumberToken() {
        int val = 0;
        while ((pos < tokenStr.length) && Character.isDigit(tokenStr[pos])) {
            val = 10*val + tokenStr[pos] - '0';
            pos++;
        }

        return new NumberToken(val);

    }

    private OperatorToken readOperatorToken() {
        Character op = tokenStr[pos++];

        if ((op != '*') && (op != '/') && (op != '-') && (op != '+')) {
            throw new RuntimeException("Found " + op + " expecting an operator at position " + (pos-1) + ".");
        }

        return new OperatorToken(op);

    }

    private LeftParenToken readLeftParenToken() {
        Character leftParen = tokenStr[pos++];
        return new LeftParenToken(leftParen);
    }

    private RightParenToken readRightParenToken(){
        Character rightParen = tokenStr[pos++];
        return new RightParenToken(rightParen);
    }

    private void skipSpaces() {
        while ((pos < tokenStr.length) && (Character.isWhitespace(tokenStr[pos]))) {
            pos++;

        }
    }

    public Token nextToken() {
        skipSpaces();
        if (pos >= tokenStr.length) {
            return null;
        }

        else if (Character.isDigit(tokenStr[pos])) {
            return readNumberToken();
        }

        else if (tokenStr[pos] == '(') {
            return readLeftParenToken();
        }

        else if (tokenStr[pos] == ')') {
            return readRightParenToken();
        }

        else {
            return readOperatorToken();
        }
    }


}
