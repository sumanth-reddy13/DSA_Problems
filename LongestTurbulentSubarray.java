public class LongestTurbulentSubarray {

	public static void main(String[] args) {
		// You can test your implementation here
	}


/**
 *   1. Maintain a flip variable that is iniatiated to 0. 
 * 	 2. If arr[i] > arr[i + 1], assign 1 to flip. If arr[i] < arr[i + 1], assign -1 to flip. 
 *   3. For every i value, update maxLen variable. 
 */
	public static int maxTurbSubarray(int[] nums) {

		int n = nums.length;
		int flip = 0;
		int maxLen = 0;
		int start = 0;

		for (int i = 0; i < n - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if (flip == 0 || flip == -1) {
					flip = 1;
					maxLen = Math.max(maxLen, i - start + 1);
				} else {
					start = i;
				}
			}
			else if (nums[i] < nums[i + 1]) {
				if (flip == 0 || flip == 1) {
					flip = -1;
					maxLen = Math.max(maxLen, i - start + 1);
				} else {
					start = i;
				}
			} else {
				start = i;
				flip = 0;
			}
		}

		return maxLen + 1;
	}

	public static int maxTurbSubarray2(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int ans = Math.max(solve(i, 0, nums), solve(i, 1, nums));
			maxLen = Math.max(maxLen, ans);
		}

		return maxLen + 1;
	}

	public static int solve(int i, int flip, int[] nums) {
		if (i == nums.length) {
			return 0;
		}

		if (flip == 0) {
			if (nums[i] >= nums[i + 1]) return 0;
			return 1 + solve(i + 1, 1, nums);
		}
		else if (flip == 1) {
			if (nums[i] <= nums[i + 1]) return 0;
			return 1 + solve(i + 1, 0, nums);
		}

		return 0;
	}
}


