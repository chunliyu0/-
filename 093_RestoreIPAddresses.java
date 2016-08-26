/* Analysis - DFS */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        if(s==null || s.length() > 12)return ret;
        dfs(ret, "", s, 0);
        return ret;
    }
    
    public void dfs(List<String> ret, String curr, String str, int n){
        if(str.length() == 0 && n==4){
            ret.add(curr.substring(0, curr.length()-1));
            return;
        }
        
        if(str.length() == 0 || n >= 4)return;
        
        for(int i = 1; i<=3; i++){//get the length of 1, 2, 3 respectively
            if(str.length() < i)return;
            String tmp = str.substring(0,i);
            
            int start = 0, end = 0;
            if(i == 1){
                start = 0;
                end = 9;
            }
            else if(i == 2){
                start = 10;
                end = 99;
            }
            else{
                start = 100;
                end = 255;
            }
                
            if(Integer.valueOf(tmp) >= start && Integer.valueOf(tmp) <= end )
                dfs(ret, curr + tmp + ".", str.substring(i), n+1);
        }
    }
}
