/* Analysis - DFS 
Remove the repeated ones
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(ret, new ArrayList<>(), nums, 0);
        return new ArrayList<List<Integer>>(ret);
    }
    
    public void dfs(List<List<Integer>> ret, List<Integer> curr, int[] nums, int i) {
        if(i == nums.length){
            if(!ret.contains(curr))ret.add(curr);
            return;
        }
        List<Integer> tmp1 = new ArrayList<>(curr);
        dfs(ret, tmp1, nums, i+1);
        
        List<Integer> tmp2 = new ArrayList<>(curr);
        tmp2.add(nums[i]);
        dfs(ret, tmp2, nums, i+1);
    }
}
