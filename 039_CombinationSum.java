/* Analysis - DFS */

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> ret = new HashSet<List<Integer>>();
        dfs(ret, new ArrayList<Integer>(), candidates, 0, target);
        return new ArrayList<>(ret);
    }
    
    public void dfs(Set<List<Integer>> ret, List<Integer> curr, int[] arr, int i, int target){
        if(target == 0){
            if(!ret.contains(curr))ret.add(curr);
            return;
        }
        if(i == arr.length)return;
        
        if(arr[i] <= target){
            //add the current element to the curr list and stay where we are
            List<Integer> tmp1 = new ArrayList<>(curr);
            tmp1.add(arr[i]);
            dfs(ret, tmp1, arr, i, target-arr[i]);
            
            //add the current element to the curr list and move forward
            List<Integer> tmp2 = new ArrayList<>(curr);
            tmp2.add(arr[i]);
            dfs(ret, tmp2, arr, i+1, target-arr[i]);
        }
        
        //ignore the current element to the curr list and move forward
        dfs(ret, curr, arr, i+1, target);
        
    }
}
