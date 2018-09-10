package unit4.prac_test2.complete;

public class Task3 {
	public static final int PWORD_VALID = 0;
	public static final int PWORD_TOO_SHORT = 1;
	public static final int PWORD_NEEDS_DIGITS = 2;
	public static final int PWORD_NEEDS_CAPITALS = 3;
	public static final int PWORD_NEEDS_LOWERCASE = 4;
	public static final int PWORD_NEEDS_PUNCTUATION = 5;

	public static final String[] RESULT = { "Valid password",
			"Password too short.", "Password must contain at least 2 digits.",
			"Password must contain at least 2 capital letters.",
			"Password must contain at least 2 lowercase letters.",
			"Password must contain at least 1 comma, period, or exclamation point." };

	public static int checkPassword(String s) {

		char[] c = s.toCharArray();

		int digits = 0;
		int capitals = 0;
		int lowercase = 0;
		int punctuation = 0;

		if (s.length() < 8)
			return PWORD_TOO_SHORT;

		for (int i = 0; i < c.length; i++) {
			char ch = c[i];

			if (Character.isDigit(ch))
				digits++;

			if (Character.isUpperCase(ch))
				capitals++;

			if (Character.isLowerCase(ch))
				lowercase++;

			if ((ch == '.') || (ch == ',') || (ch == '!'))
				punctuation++;
		}
		if (digits < 2)
			return PWORD_NEEDS_DIGITS;

		if (capitals < 2)
			return PWORD_NEEDS_CAPITALS;

		if (lowercase < 2)
			return PWORD_NEEDS_LOWERCASE;

		if (punctuation < 1)
			return PWORD_NEEDS_PUNCTUATION;

		return PWORD_VALID;
	}

	public static void main(String[] args) {
		String[] s = { "45HJas.g", "dhjAA879!", "Sh3", "kjhfASDF.",
				"KDAD12.!3", "5fgda12?", "5fgda12BC" };

		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i] + ": " + RESULT[checkPassword(s[i])]);
		}
	}

}
