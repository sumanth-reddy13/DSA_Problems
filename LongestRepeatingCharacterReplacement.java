public class LongestRepeatingCharacterReplacement {
	public static void main(String[] args) {
		
		String s = "AABABBA";
		int k = 1;
		int result = characterReplacement(s, k);
		System.out.println("Longest substring length: " + result); // Output: 4		
	}

	public static int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int maxCount = 0;
		int left = 0;
		int maxLength = 0;

		for (int right = 0; right < s.length(); right++) {
			count[s.charAt(right) - 'A']++;
			maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

			while (right - left + 1 - maxCount > k) {

				for (int i = 0; i < 26; i++) {
					maxCount = Math.max(maxCount, count[i]);
				}
				count[s.charAt(left) - 'A']--;
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}
}