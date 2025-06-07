
/**
 * 
 *   The maximum subarray sum is solved using following approaches:
 *   1. Brute Force Approach
 *   2. Prefix Sum Approach 			- Maintain a running sum and a minimum prefix sum. 
 *   3. Recursive Approach 				- At each index, either include the current element to the running sum or start a new subarray with the current element.
 *   4. Dynamic Programming Approach	- Maintain a dp array where dp[i] is the maximum subarray sum ending at index i.
 *   5. Divide and Conquer Approach 	- Divide the array into two halves. calculate the maxx. subarray sum in each half and the maximum subarray sum that crosses the midpoint.
 *   6. Kadane's Algorithm
 * 
 */

public class MaximumSubarray {
	static int maxSumRecursive; 
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

		maxSumRecursive = nums[0]; 
		maxSubArrayRecursive(nums, 1, nums[0]);

		maxSubArrayKadaneAlgo(nums);
	}

	// Recursive Approach - TC: O(2^n)  SC: O(n)
	public static void maxSubArrayRecursive(int[] nums, int index, int runningSum) {

		maxSum = Math.max(maxSum, runningSum);
		if (index == nums.length) {
			return; 
		}

		maxSubArrayRecursive(nums, index + 1, runningSum + nums[index]);
		maxSubArrayRecursive(nums, index + 1, nums[index]);
	}

	// Kadane's Algorithm - TC: O(n)  SC: O(1)
	public static int maxSubArrayKadaneAlgo(int[] nums) {
		int maxSum = nums[0];
		int currentSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			maxSum = Math.max(maxSum, currentSum);
		}

		return maxSum;
	}

	// Dynamic Programming Approach - TC: O(n)  SC: O(1)
	public static int maxSubArrayDP(int[] nums) {
    	int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum; 
	}

	// Divide and Conquer Approach - TC: O(n log n)  SC: O(log n)
	public static int maxSubArrayDivideAndConquer(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		}

		int mid = (left + right) / 2;
		int leftMax = maxSubArrayDivideAndConquer(nums, left, mid);
		int rightMax = maxSubArrayDivideAndConquer(nums, mid + 1, right);

		int crossMax = findCrossMax(nums, left, mid, right);

		return Math.max(Math.max(leftMax, rightMax), crossMax);
	}

	public static int findCrossMax(int[] nums, int left, int mid, int right) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = mid; i >= left; i--) {
			sum += nums[i];
			leftSum = Math.max(leftSum, sum);
		}

		int rightSum = Integer.MIN_VALUE;
		sum = 0;

		for (int i = mid + 1; i <= right; i++) {
			sum += nums[i];
			rightSum = Math.max(rightSum, sum);
		}

		return leftSum + rightSum;
	}

	// Brute Force Approach - TC: O(n^2)  SC: O(1)
	public static int maxSubArrayBruteForce(int[] nums) {
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int currentSum = 0;
			for (int j = i; j < nums.length; j++) {
				currentSum += nums[j];
				maxSum = Math.max(maxSum, currentSum);
			}
		}

		return maxSum;
	}

	// Prefix Sum Approach - TC: O(n)  SC: O(n)
	public static int maxSubArrayPrefixSum(int[] nums) {
      	int curr = 0;
        int min = 0; 
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            maxSum = Math.max(maxSum, curr - min);
            min = Math.min(min, curr);
        }

        return maxSum;;
	}
}


// Print Max Subarray Sum

public static printMaxSumSubaray(int[] nums) {
	int maxSum = nums[0];
	int currentSum = nums[0];
	int start = 0;
	int end = 0;
	int tempStart = 0;

	for (int i = 1; i < nums.length; i++) {
		currentSum += nums[i];

		if (currentSum < nums[i]) {
			currentSum = nums[i];
			tempStart = i;
		}

		if (currentSum > maxSum) {
			maxSum = currentSum;
			start = tempStart;
			end = i;
		}
	}
}