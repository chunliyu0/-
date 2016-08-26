/* Analysis - DFS */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        dfs(set, new ArrayList<Integer>(), candidates, 0, target);
        return new ArrayList(set);
    }
    
    public void dfs(HashSet<List<Integer>> set, List<Integer> curr, int [] arr, int i, int target){
        if(target == 0){
            Collections.sort(curr);
            if(!set.contains(curr))set.add(curr);
            return;
        }
        if(i==arr.length || target < 0)return;
        
        if(arr[i] <= target){
            List<Integer> tmp = new ArrayList<>(curr);
            tmp.add(arr[i]);
            dfs(set, tmp, arr, i+1, target-arr[i]);
        }
        dfs(set, curr, arr, i+1, target);
    }
}
