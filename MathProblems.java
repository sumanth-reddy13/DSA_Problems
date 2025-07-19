class MathProblems {
	public static void main(String[] args) {

	}

	/**
	 * Function to check if a number is prime.
	 * Given n numbers, the time complexity to find prime numbers from 1 to n is O(n * sqrt(n)).
	 */
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	/*
	 	* Euclid's Algorithm to find GCD of two numbers.
		* GCD(a, b) = GCD(b, a - b) if a >= b
		* (a % b) does same thing as (a - b), but efficiently.
	*/
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	
	// Fast exponentiation
	public static long fastExp(long base, long power, int mod) {
	    long res = 1; 
	    
	    while (power != 0) {
	        if ((power & 1) == 1) {
	            res = (res * base) % mod; 
	        }
	        
	        power = power >> 1; 
	        base = (base * base) % mod; 
	    }
	    
	    return res; 
	}
}