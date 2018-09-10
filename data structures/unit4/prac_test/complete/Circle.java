package unit4.prac_test.complete;

public class Circle {
	private double r;
	
	public Circle (double r)
	{
		if (r<= 0)
			throw new IllegalRadiusException();
		this.r = r;
	}
	
	public double getCircumference ()
	{
		return 2 * Math.PI * r;
	}
}
