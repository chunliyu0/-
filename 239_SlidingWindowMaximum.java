/* Analysis - Deque 
(1) add k nums to the deque first
(2) each time add a new one, remove the expired one, as well as the previous smaller ones
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 )return new int[0];
        if(k == 1)return nums;
        
        int[] ret = new int[nums.length - k + 1];
        int idx = 0;
        Deque dq = new LinkedList<>();
        
        // initializaton - process the first scope
        for(int i = 0; i < k; i++){
            if(dq.isEmpty())
                dq.add(i); //add the index into the deque
            else{
                while(!dq.isEmpty() && nums[(int)dq.getLast()] < nums[i])
                    dq.removeLast();
                dq.add(i);
            }
        }
        ret[idx++] = nums[(int)dq.getFirst()];
        
        //process the later scopes one by one
        for(int i = k; i < nums.length; i++){
            if((int)dq.getFirst() == i - k )
                dq.removeFirst(); //pop out from the head where the element is not inside the scope
            while(!dq.isEmpty() && nums[(int)dq.getLast()] < nums[i])
                dq.removeLast();
            dq.add(i);
            ret[idx++] = nums[(int)dq.getFirst()];
        }
        
        return ret;
    }
}
