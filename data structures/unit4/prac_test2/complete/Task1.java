package unit4.prac_test2.complete;

public class Task1 {

	public static double percentVowels (String s) throws UnexpectedCharacterException
	{
		char[] c = s.toCharArray();
		
		int vowels = 0;
		
		for (int i=0; i<c.length; i++)
		{
			char ch = c[i];
			if (!Character.isLetter(ch))
				throw new UnexpectedCharacterException("Unexpected character " + ch);
			
			ch = Character.toUpperCase(ch);
			if ((ch=='A') || (ch=='E') || (ch=='I') || (ch=='O') || (ch=='U'))
				vowels++;
		}
		
		return (double) vowels / c.length * 100;
	}
	
	
	
	public static void main(String[] args) {
		String[] s = {"Happy", "Jackson", "School Days", "Gr4et", "AeIoU", "b", "16"};

		for (int i=0; i<s.length; i++)
		{
			try {
				System.out.print(s[i] + ": ");
				System.out.printf("%.1f%%\n", percentVowels(s[i]));
			}catch (UnexpectedCharacterException ex) {
				System.out.println("Illegal characters in string!");
			}
		}
	}

}


//		int numOfVowels = 0;

//		for (int i = 0; i < s.length(); i++) {
//			if (Character.toLowerCase(s.charAt(i)) == 'a' || Character.toLowerCase(s.charAt(i)) == 'e' || Character.toLowerCase(s.charAt(i)) == 'i' || Character.toLowerCase(s.charAt(i)) == 'o' || Character.toLowerCase(s.charAt(i)) == 'u')
//				numOfVowels++;
//			else if (!Character.isLetter(s.charAt(i)))
//				throw new UnexpectedCharacterException();
//		}
//		return (((double) numOfVowels) / (s.length())) * 100;