/***
 * 
 * 	1. Use Kadane`s algorithm. 
 *  2. While updating the maxSum, also update the start and end indices of the subarray.
 *  3. Keep updating the start index when currSum + nums[i] < nums[i].
 * 
 */


public class PrintMaxSubarraySum {
	public static void main(String[] args) {
		// Your code here
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int maxSum = nums[0];
		int currentSum = nums[0];
		int start = 0;
		int end = 0;
		int tempStart = 0;
		
		for (int i = 1; i < nums.length; i++) {
			currentSum += nums[i];

			if (currentSum < nums[i]) {
				currentSum = nums[i];
				tempStart = i + 1;
			}

			if (currentSum > maxSum) {
				maxSum = currentSum;
				start = tempStart;
				end = i;
			}
		}

		System.out.println("Maximum Subarray Sum: " + maxSum);
		System.out.print("Subarray: ");
		for (int i = start; i <= end; i++) {
			System.out.print(nums[i] + " ");
		}				
	}
}