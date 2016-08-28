/* Analysis - DFS */

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 1; i < 10; i++){//the MSB starts from 1 to 9
            dfs(ret, i, n);
        }
        return ret;
    }
    
    public void dfs(List<Integer> ret, int curr, int n){
        if(curr > n)return;
        
        ret.add(curr);
        for(int i = 0; i<=9; i++){//append another bit to the end
            dfs(ret, curr*10+i, n);
        }
    }
}
