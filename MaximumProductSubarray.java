

public class MaximumProductSubarray {
	public static void main(String[] args) {
		// Your code here
	}

	public static int maxProduct(int[] nums) {
        int max = nums[0]; 
        int min = nums[0]; 
        int maxValue = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int minVal = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            int maxVal = Math.max(nums[i], Math.max(nums[i] * min, nums[i] * max));

            maxValue = Math.max(maxValue, maxVal);

            min = minVal;
            max = maxVal;
        }

        return maxValue;
    }
}

/**
 *  At every iteration, we calculate curr[i], curr[i] * max, and curr[i] * min.
 *  curr[i] is used if preious previous value is negative or zero. 
 *  min value will be used if case of negative values. If previous and current value are negative, then their` product will be positive, so we need to keep track of the minimum value as well.
 *  max value will be used if case of positive values.
 */
