/* Analysis
Using the array to record the total incs first
*/

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int [] nums = new int[length];
        if(length == 0)return nums;
        
        for(int[] upd: updates){
            nums[upd[0]] += upd[2];//record the start of the incs
            if(upd[1] < length - 1){
                nums[upd[1] + 1] -= upd[2];
            }
        }
        if(length == 1) return nums;
        for(int i = 1; i<length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        
        return nums;
    }
}
