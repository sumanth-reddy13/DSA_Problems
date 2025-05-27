public class longestConsecutiveSequence {
	public static void main(String[] args) {
		
	}

	// Using Hashmap to store the length of consecutive sequence 
	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0) return 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLength = 0;

		for (int num : nums) {
			if (!map.containsKey(num)) {
				int left = map.getOrDefault(num - 1, 0);
				int right = map.getOrDefault(num + 1, 0);
				int length = left + right + 1;

				map.put(num, length);
				maxLength = Math.max(maxLength, length);

				map.put(num - left, length); // Update the start of the sequence
				map.put(num + right, length); // Update the end of the sequence
			}
		}

		return maxLength;
	}

	// Store the unique elements in a HashSet and iterate through the hashset to find the first occuring 
	// element in the set and start looking for a consecutive sequence from the first occuring element.

	public static Set<Integer> storeUniqueElements(int[] nums) {
		HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int max = 0; 
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1; 
                int val = num;
                while (set.contains(val + 1)) {
                    count++;
                    val++;
                }
                max = Math.max(max, count);
            }
        }

        return max; 
	}
}