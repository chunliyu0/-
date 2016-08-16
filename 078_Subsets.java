/* Analysis - DFS */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        DFS(ret, curr, nums, 0);
        return ret;
    }
    
    public void DFS(List<List<Integer>> ret, List<Integer> curr, int[] nums, int i) {
        if(i == nums.length){
            ret.add(curr);
            return;
        }
        List<Integer> tmp1 = new ArrayList<>(curr);
        DFS(ret, tmp1, nums, i+1);
        
        List<Integer> tmp2 = new ArrayList<>(curr);
        tmp2.add(nums[i]);
        DFS(ret, tmp2, nums, i+1);
    }
}
