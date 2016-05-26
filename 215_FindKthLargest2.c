/* Analysis
Using Array.Sort() to sort the array first
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
       Arrays.sort(nums);
       return nums[nums.length-k];
    }
}
