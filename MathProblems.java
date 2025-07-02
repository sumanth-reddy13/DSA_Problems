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

	1. Sieve of Eratosthenes
	2. 
	
}