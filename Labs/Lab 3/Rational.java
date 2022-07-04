public class Rational {

    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
	    // Your code here
        this.numerator = numerator;
        this.denominator = 1;
        reduce();
    }

    public Rational(int numerator, int denominator) {
	    // Your code here
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    // getters

    public int getNumerator() {
	    return this.numerator;
    }

    public int getDenominator() {
	    return this.denominator;
    }

    // instance methods

    public Rational plus(Rational other) {
	    // Your code here
        if (this.denominator == other.denominator) {
            return new Rational(this.numerator + other.numerator, this.denominator);
        } else {
            return new Rational((this.numerator * other.denominator) + (other.numerator * this.denominator), this.denominator * other.denominator);
        }
    }

    public static Rational plus(Rational a, Rational b) {
    	// Your code here
        if (a.denominator == b.denominator) {
            return new Rational(a.numerator + b.numerator, a.denominator);
        } else {
            return new Rational((a.numerator * b.denominator) + (b.numerator * a.denominator), a.denominator * b.denominator);
        }
    }

    // Transforms this number into its reduced form

    private void reduce() {
        // Your code here
        int myGcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / myGcd;
        this.denominator = this.denominator / myGcd;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
        // Note that the loop below, as-is, will time out on negative inputs.
        // The gcd should always be a positive number.
        // Add code here to pre-process the inputs so this doesn't happen.

        int remainder = -1;
        int answer = 1;
        int num = a;
        int den = b;

        while (remainder != 0) {
            remainder = num % den;
            num = den;
            den = remainder;
            answer = num;
        }
        return answer;
    }

    public int compareTo(Rational other) {
        // Your code here
        int result = 0;
        if ((double)this.numerator / (double)this.denominator > (double)other.numerator / (double)other.denominator) {
            result = 1;
        } else if ((double)this.numerator / (double)this.denominator < (double)other.numerator / (double)other.denominator) {
            result = -1;
        } 
        return result;
    }

    public boolean equals(Rational other) {
        // Your code here
        return this.numerator == other.numerator && this.denominator == other.denominator ;
    }

    public String toString() {
    	String result;
    	if (this.denominator == 1) {
    	    // Your code here
            result = this.numerator + "";
    	} else {
    	    // Your code here
            result = this.numerator + "/" + this.denominator;
    	}
    	return result;
    }

}
