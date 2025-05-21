public class SortColors {
	public static void main(String[] args) {
		// Your code goes here
		System.out.println("Hello, World!");
	}

	public static void sortColors(int[] nums) {
        
        int zero = 0; 
        int one = 0; 
        int two = 0; 
        int n = nums.length; 

        for (int i : nums) {
            if (i == 0) zero++; 
            else if (i == 1) one++; 
            else if (i == 2) two++; 
        }

        one += zero; 
        two += one; 

        for (int i = 0; i < n; i++) {
            if (i < zero) nums[i] = 0; 
            else if (i < one) nums[i] = 1;
            else if (i < two) nums[i] = 2; 
        }
    }

	/**
	 * 
	 *  1. When nums[i] == 0, we increment i and zero. Since zero is tracking '0', it will always be less than or equal to i. 
	 *     If it is less than i, it means that there is a 1 at index zero. so when we swap zero and i, 1 will come at index i. 
	 * 	   In the upcoming iterations, if there is 0, that 1 will be swapped with 0.
	 */

	public static void sortColorsOnePass(int[] nums) {
		int zero = 0;
		int i = 0; 
		int two = nums.length - 1;

		while (i <= two) {
			if (nums[i] == 0) {
				swap(nums, i, zero);
				zero++;
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				swap(nums, i, two);
				two--;
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}