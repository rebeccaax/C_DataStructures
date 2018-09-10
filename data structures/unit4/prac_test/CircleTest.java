package unit4.prac_test;

public class CircleTest {

	public static void main(String[] args) {
		try {
			Circle c = new Circle(7);
			System.out.println(c.getCircumference());

			c = new Circle(-7);
			System.out.println(c.getCircumference());
		}
		catch (Exception e) {
			System.out.println("Illegal radius.");

		}

	}
}
