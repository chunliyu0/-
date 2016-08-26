/* Analysis - DFS */

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(ret, new ArrayList<Integer>(), n, k, 0);
        return ret;
    }
    
    public void dfs( List<List<Integer>> ret, List<Integer> curr, int target, int k, int start){
        if(target == 0 && k == 0){
            ret.add(curr);
            return;
        }
        
        if(k == 0 || target <= 0 || start == 9)return;
        
        //add the current processing number to the curr list
        List<Integer> tmp = new ArrayList<Integer>(curr);
        tmp.add(start+1);
        dfs(ret, tmp, target - (start+1), k-1, start + 1);
        
        //not add the current processing number to the curr list
        dfs(ret, curr, target, k, start + 1);
    }
}
