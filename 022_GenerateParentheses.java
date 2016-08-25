/* Analysis - DFS */

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        dfs(ret, "", 0, n);
        return ret;
    }
    
    public void dfs(List<String> ret, String str, int count, int n) {//count is the current single left parenthesis
        if(str.length()==2*n){
            if(count==0)ret.add(str);
            return;
        }
        
        if(count>0)//add the right parenthesis
            dfs(ret, str+")", count-1, n); 
        if(count<n)//add left parenthesis
            dfs(ret, str+"(", count+1, n);  
    }
}
