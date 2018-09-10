package unit4.prac_test.complete;

public class Task1 {

	public static int compareCases(String s) {
		char[] c = s.toCharArray();
		int upper = 0;
		int lower = 0;

		for (int i = 0; i < c.length; i++) {
			if (Character.isUpperCase(c[i]))
				upper++;
			else if (Character.isLowerCase(c[i]))
				lower++;
			else
				throw new IllegalArgumentException("Illegal character -- " + c[i] + " is not a letter.");
		}

		return upper - lower;
	}

	public static void main(String[] args) {
		System.out.println(compareCases ("ABBh"));
		System.out.println(compareCases ("MaGdHij"));
		System.out.println(compareCases ("JHGFKJSL"));
	}
}
