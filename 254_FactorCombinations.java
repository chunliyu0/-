/* Analysis - DFS */

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(n == 1)return ret;
        
        dfs(ret, new ArrayList<Integer>(), 1, n, 2);
        return ret;
    }
    
    public void dfs(List<List<Integer>> ret, List<Integer> curr, int product, int n, int idx){
        if(product == n){
            ret.add(curr);
            return;
        }
        if(product > 1 && product < Math.sqrt(n) && n % product == 0){
            List<Integer> tmp = new ArrayList<Integer>(curr);
            tmp.add(n / product);
            ret.add(tmp);
        }
        
        for(int i = idx; i*i <= n; i++){
            if(product * i > n)break;
            if(n%i != 0)continue; //i is not the divisor
            
            List<Integer> tmp = new ArrayList<Integer>(curr);
            tmp.add(i);
            dfs(ret, tmp, product*i, n, i);
        }
    }
}
