/* Analysis
PriorityQueue = queue(FIFO) + minHeap
(1)the element at index 0 is always the min value in the priorityqueue
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
       for(int num: nums){
           pq.offer(num);
           if(pq.size()>k){
               pq.poll();//add element to the PriorityQueue
           }
       }
       return pq.peek();//get the 1st element in the PriorityQueue
    }
}
