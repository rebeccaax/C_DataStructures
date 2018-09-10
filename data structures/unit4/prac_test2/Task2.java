package unit4.prac_test2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		try {
			File f = new File("Nothing");
			Scanner s = new Scanner(f);
			System.out.println("Hello world");
			s.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("The file was not found.");
		}
	}
}
