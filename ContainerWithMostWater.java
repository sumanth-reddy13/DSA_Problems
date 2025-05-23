public class ContainerWithMostWater {
	public static void main(String[] args) {
		
	}

	// Two pointer approach, TC: O(n), SC: O(1)
	public int maxArea(int[] height) {
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int width = right - left;
			int minHeight = Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, width * minHeight);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	// Brute force approach, TC: O(n^2), SC: O(1)
	public int maxAreaBruteForce(int[] height) {
		int maxArea = 0;

		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int width = j - i;
				int minHeight = Math.min(height[i], height[j]);
				maxArea = Math.max(maxArea, width * minHeight);
			}
		}

		return maxArea;
	}
}