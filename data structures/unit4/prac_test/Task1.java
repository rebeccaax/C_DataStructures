package unit4.prac_test;

public class Task1 {

	public static int compareCases (String s) {
		int upper = 0;
		int lower = 0;
		char[] c_array = s.toCharArray();
		for (int i = 0; i < c_array.length; i++) {
			if (Character.isUpperCase(c_array[i])) {
				upper++;
			}
			else if (Character.isLowerCase(c_array[i])) {
				lower++;
			}

			else {
				throw new IllegalArgumentException("Illegal character -- " + c_array[i] + " is not a letter.");
			}
		}
		return upper - lower; // This is a placeholder. Replace this return value.
	}
	
	public static void main(String[] args) {
		System.out.println(compareCases ("ABBh"));
		System.out.println(compareCases ("MaGdHij"));
		System.out.println(compareCases ("JHGFKJSL"));
	}
}
// Character.isLowerCase('c')


