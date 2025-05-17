public class DegreeOfAnArray {

	public static void main(String[] args) {
		
	}

/**
 * 	Approach 1: HashMap & ArrayList
 * 
 *  1. Find the maximum frequency value in the array using a Hashmap. 
 *  2. Iterate through the hashmap results to check the maximum frequency number. 
 *  3. Iterate through the hashmap again to find the elements that have the maximum frequency.
 *  4. For each number in the list, find the subarray length.
 *  5. Return the minimum length of the subarray.
 */

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int n = nums.length; 

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(); 
        int maxFreq = 0; 

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            int num = mp.getKey(); 
            int numFreq = mp.getValue(); 

            if (numFreq > maxFreq) maxFreq = numFreq; 
        }

        System.out.println("max freq : " + maxFreq);

        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            int num = mp.getKey(); 
            int numFreq = mp.getValue(); 

            if (numFreq == maxFreq) list.add(num);
        }

        System.out.println(list);
        int minLen = Integer.MAX_VALUE;
        
        for (int j = 0; j < list.size(); j++) {
            int maxFreqNum = list.get(j);
            int startIndex = -1; 
            int endIndex = -1; 

            for (int i = 0; i < n; i++) {
                if (nums[i] == maxFreqNum) {
                    if (startIndex == -1) startIndex = i; 
                    endIndex = i; 
                }
            }

            System.out.println("maxFreqNum: " + maxFreqNum);
            System.out.println("startIndex: " + startIndex);
            System.out.println("endIndex: " + endIndex);

            minLen = Math.min(minLen, (endIndex - startIndex + 1));
        }

        return minLen; 
    }

	/**
	 *  Approach 2: HashMap (Optimized)
	 *  
	 *  1. Iterate throuth the array and for each element HashMap will store the frequency, start index and end index of each unique number. 
	 *  2. Iterate through the HashMap values and find the maximum frequency.
	 */

	public static int findShortestSubArrayOptimized(int[] nums) {
		HashMap<Integer, int[]> map = new HashMap<>(); 
		int n = nums.length; 

		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				map.get(num)[0]++; // frequency
				map.get(num)[2] = i; // end index
			}
			else {
				map.put(num, new int[] {1, i, i}); // frequency, start index, end index
			}
		}

		int maxFreq = 0; 
		int minLen = Integer.MAX_VALUE;

		for (Map.Entry<Integer, int[]> mp : map.entrySet()) {
			int numFreq = mp.getValue()[0]; 
			int startIndex = mp.getValue()[1]; 
			int endIndex = mp.getValue()[2]; 

			if (numFreq > maxFreq) {
				maxFreq = numFreq;
				minLen = endIndex - startIndex + 1;
			}
			else if (numFreq == maxFreq) {
				minLen = Math.min(minLen, endIndex - startIndex + 1);
			}
		}

		return minLen; 
	}


	/**
	 * Approach 3: Using Two HashMaps
	 * 
	 * 1. Create two HashMaps (First, Freq). First stores the first occurrence incdex of a number. Freq stores the frequency of the number. 
	 * 2. Maintain 2 variables (degree, minLen). Traverse the array and keep updating minLen if frequency of the current element is > degree. 
	 */

	public static int findShortestSubArrayTwoHashMaps(int[] nums) {
		HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>(); 

        int degree = 0; 
        int minLen = 5_000_1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!first.containsKey(num)) {
                first.put(num, i);
            }

            freq.put(num, freq.getOrDefault(num, 0) + 1);

            if (freq.get(num) > degree) {
                minLen = i - first.get(num) + 1;
                degree = freq.get(num);
            }
            else if (freq.get(num) == degree) {
                minLen = Math.min(minLen, i - first.get(num) + 1);
            }
        }

        return minLen;
	}
}