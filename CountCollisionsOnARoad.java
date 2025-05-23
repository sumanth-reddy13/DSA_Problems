public class CountCollisionsOnARoad {
	public static void main(String[] args) {
		// Test the function with an example
		String directions = "RLRSLL";
		int result = countCollisions(directions);
		System.out.println("Total collisions: " + result); // Output: 5
	}

	// Function to count the number of collisions on a road
	public static int countCollisions(String directions) {
        int n = directions.length(); 
        int left = 0, right = n - 1; 

        while (left < n && directions.charAt(left) == 'L') left++;
        while (right > -1 && directions.charAt(right) == 'R') right--;

        int collisions = 0; 
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') collisions++; 
        } 

        return collisions; 
	}

}