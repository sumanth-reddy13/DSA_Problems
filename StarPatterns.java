public class starPatterns {
	public static void main(String[] args) {
		
	}

	//     *
	//    ***
	//   *****
	//  *******
	// *********

	public static void pattern1(int n) {
		for (int i = 0; i < n; i++) {
            int stars = 2 * i + 1; 
            int spaces = n - i - 1; 
            
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}

	/*
			1 
			0 1 
			1 0 1 
			0 1 0 1 
			1 0 1 0 1
	 */
	public static void pattern2(int n) {
		int flag = 1; 
        
        for (int i = 1; i <= n; i++) {
            int value = flag; 
            for (int j = 1; j <= i; j++) {
                System.out.print(value + " ");
                value ^= 1; 
            }
            flag ^= 1; 
            System.out.println();
        }
	}

/**
 * 
			1      1
			12    21
			123  321
			12344321
 */

	public static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            int stars = i; 
            int spaces = 2 * (n - i);
            
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
	}

	

}