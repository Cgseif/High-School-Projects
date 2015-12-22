package Rationals;

class Rational
{
	// Privates
	private int numerator;
	private int denominator;

	// Constructors
	public Rational()
	{
		numerator = 0;
		denominator = 0;
	}

	public Rational(int n, int d)
	{
		numerator = n;
		denominator = d;
	}

	// Whole numbers with denominator of 1
	public Rational(int n)
	{
		numerator = n;
		denominator = 1;
	}
	
	// Inspectors
	public int getNumerator()
	{
		return numerator;
	}

	public int getDenominator()
	{
		return denominator;
	}

	// Mutators
	public int setNumerator(int n)
	{
		return numerator = n;
	}

	public int setDenominator(int d)
	{
		return denominator = d;
	}

	// Facilitators
	public String toString()
	{
		if (denominator == 1)
			return "" + numerator + "";
		else
			return "("+ numerator + "/" + denominator + ")";
	}

	// We may be able to remove this
	public Rational reciprocal()
	{
		Rational result = new Rational(denominator, numerator);
		return result;
	}

	public Rational add(Rational r)
	{
		Rational result = new Rational();
		int lcd = denominator * r.getDenominator();
		int n1 = numerator * r.getDenominator();
		int n2 = r.getNumerator() * denominator;
		result.setNumerator(n1 + n2);
		result.setDenominator(lcd);
		return result;
	}

	public Rational subtract(Rational r)
	{
		Rational result = new Rational();
		int lcd = denominator * r.getDenominator();
		int n1 = numerator * r.getDenominator();
		int n2 = r.getNumerator() * denominator;
		result.setNumerator(n1 - n2);
		result.setDenominator(lcd);
		return result;
	}

	public Rational multiply(Rational r)
	{
		Rational result = new Rational();
		result.setNumerator(numerator * r.getNumerator());
		result.setDenominator(denominator * r.getDenominator());
		return result;
	}

	public Rational divide(Rational r)
	{
		Rational result = new Rational();
		result = multiply(r.reciprocal());
		return result;
	}

	public boolean equals(Rational r)
	{
		return (numerator == r.getNumerator() && denominator == r.getDenominator());
	}

	public Rational average(Rational r)
	{
		Rational result = new Rational();
		result.setNumerator((numerator + r.getNumerator()) / 2);
		result.setDenominator(denominator * r.getDenominator());
		return result;
	}
}