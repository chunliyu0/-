/* Analysis
(1) find the index at which the number should be replaced
(2) since the last part is decreasing, we need to reverse it
(3) only if we need to swap, we do the swap
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length<2)return;
        
        int i = nums.length - 1;
        while(i>=1 && nums[i-1] >= nums[i]){// the array is increasing from the back
            i--;
        }
        
        reverse(nums, i, nums.length - 1);
        if(i==0)return;
        
        int idx = i-1;
        while(nums[idx] >= nums[i]){
            i++;
        }
        swap(nums, idx, i);
    }
    
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums, start, end);
            start ++;
            end--;
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
