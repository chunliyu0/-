/* Analysis - Binary Search 
(1) the array may not be sorted
(2) if there are 10 (1-9) numbers without repeation, the mid is 5, normally there are 5 numbers less than or equal to mid;
    if there are 11 (1-10) numbers without repeation, the mid is 5, normally there are 5 number less than or equal to mid;
*/

public class Solution {  
    public int findDuplicate(int[] nums) {
        int low = 0, high = nums.length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(count(nums, mid) <= mid)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    } 
    
    public int count(int[] nums, int target) {  
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] <= target)
                count++;
        }
        return count;
    } 
}  
