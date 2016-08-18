/* Analysis - DFS */

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        DFS(ret, curr, n, k, 1);
        return ret;
    }
    
    public void DFS(List<List<Integer>> ret, List<Integer> curr, int n, int k, int i) {
        //System.out.println("i = " + i + ": " + curr);
        if(curr.size()==k){
            ret.add(curr);
            return;
        }
        if(i > n)return;
        
        //choose to add the current number;
        List<Integer> list = new ArrayList<>(curr);
        list.add(i);
        DFS(ret, list, n, k, i+1);
        
        //choose not to add the current number;
        DFS(ret, curr, n, k, i+1);
    }
}
