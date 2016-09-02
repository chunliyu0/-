/* Analysis - PriorityQueue */

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
			    return (arr2[0] + arr2[1]) - (arr1[0] + arr1[1]);
		    }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(3, comparator);
        for(int val1: nums1){
            for(int val2: nums2){
                pq.offer(new int []{val1, val2});
                if (pq.size() > k){
                    pq.poll();
                }
            }
        }
        
        return new ArrayList<int[]>(pq);
    }
}
