public class ValidAnagrams {
	public static void main(String[] args) {
		// Your code here
	}

	public boolean isAnagram(String s, String t) {
        int parent[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            parent[ch1 - 'a'] = parent[ch1 - 'a']++;
            parent[ch2 - 'a'] = parent[ch2 - 'a']--;
        }

        System.out.println(Arrays.toString(parent));

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != 0) return false;
        }
        return true; 
    }

	public boolean isAnagramUsingMap(String s, String t) {
		        int len1 = s.length(); 
        int len2 = t.length(); 

        if (len1 != len2) return false;

        HashMap<Character, Integer> mp1 = new HashMap<>(); 
        HashMap<Character, Integer> mp2 = new HashMap<>(); 
        
        for (int i = 0; i < len1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            mp1.put(ch1, mp1.getOrDefault(ch1, 0) + 1);
            mp2.put(ch2, mp2.getOrDefault(ch2, 0) + 1);
        }

        for (int i = 0; i < len1; i++) {
            char ch1 = s.charAt(i);

            if (mp1.containsKey(ch1) && mp2.containsKey(ch1)) {
                mp1.put(ch1, mp1.get(ch1) - 1);
                mp2.put(ch1, mp2.get(ch1) - 1);

                if (mp1.get(ch1) == 0) mp1.remove(ch1);
                if (mp2.get(ch1) == 0) mp2.remove(ch1);
            }
            else return false;
        }

        return true;
	}

	// Approach - 3

	/**
		1. Add characters from both string into seperate ArrayLists. 
		2. Sort the ArrayList. 
		3. Compare both the ArrayLists and if at any point they are not equal,return false
		4. After the iteration, return true
	 */
}