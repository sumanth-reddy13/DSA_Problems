

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