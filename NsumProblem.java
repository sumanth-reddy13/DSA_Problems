public class NsumProblem {
	public static void main(String[] args) {
		// Your code here
	}

	/**
	 *  1. N Sum problem can be solved using a recursion. The base case is to solve a 2 sum problem. 
	 *  2. call the function with (target - nums[i], i + 1, N - 1) whenever N is more than 2
	 *  3. You can use a two pointer approach to find the 2 sum problem if the array is sorted. 
	 *  4. If the array is not sorted, use a HashMap. For each iteration, check if target - nums[i] is present in the map. else add nums[i] to the map.
	 */

}