public class TopKFreqElements {
	public static void main(String[] args) {

	}

/*
    Approach 1: using Bucket Sort. TC - 
    
	1. Use a HashMap to store the the frequency of unique number in the array.
	2. Create an array of length n + 1 [n is the length of the given array]. Each index of the array represents the frequency. It will store the values that have the frequency of the index. 
	3. Iterate the HashMap and store the value at freq index in the array. 
	4. Iterate the array from the end and add K values to the resultant array.
*/
	public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] arr = new ArrayList[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>(); 

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>(); 
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue(); 
            int num = entry.getKey(); 
            arr[freq].add(num);
        }
        int[] res = new int[k];
        int index = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            List<Integer> tempList = arr[i];

            if (tempList.size() > 0 && k > 0) {
                for (int j : tempList) {
                    res[index++] = j;
                }
                k -= tempList.size(); 
            }
        }

        return res; 
    }


/**
    Approach 2: Brute Force approach. [TC - O(N^2)]

    1. Use a HashMap to store the the frequency of unique number in the array.
    2. Iterate through HashMap "K" times to find maximum occurring value at each iteration. Add the value to the resultant Array.
*/

/*
	Approach 3: Max-Heap
	
	1. Using Priority Queue Max-Heap Implementation to retreive Top K elements from the PQ. [TC: O(N log N)]
*/
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>(); 
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            pq.offer(new Pair(mp.getKey(), mp.getValue()));
        }

        while (!pq.isEmpty() && k-- > 0) {
            res.add(pq.poll().num);
        }

        int[] result = new int[res.size()];
        int x = 0; 

        for (int i = 0; i < res.size(); i++) {
            result[x++] = res.get(i);
        }

        return result; 
    }
}