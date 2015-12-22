package Rationals;

class Program
{
	public static void main(String[] args)
	{
		Rational frac1 = new Rational(1,2);
		Rational frac2 = new Rational(3,4);
		System.out.println("It worked!");

		System.out.println(frac1);
		System.out.println(frac2);
		System.out.println(frac1.add(frac2));
		//System.out.println(frac1.average(frac2)); // faulty
		System.out.println(frac1.divide(frac2));
	}
}