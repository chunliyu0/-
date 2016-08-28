/* Analysis - DFS */

public class Solution {
    String [] mids = {"0", "1", "8"};
    String [] ref = {"00", "11", "69", "96", "88"};
   
    public List<String> findStrobogrammatic(int n) {
        if(n == 1) return Arrays.asList(mids);//deal with the special case when n == 1
        List<String> ret = new ArrayList<String>();
        
        for(int i = 1; i<ref.length; i++){//to get rid of the 0s in the beginning
            dfs(ret, ref[i], n-2);
        }
        
        return ret;
    }
    
    public void dfs(List<String> ret, String curr, int n){//spand from inside
        if(n == 0){
            ret.add(curr);
            return;
        }
        if(n == 1){
            for(String mid: mids)
                ret.add(concatenate(curr, mid));
            return;
        }
        for (String str: ref) {
            String tmp = concatenate(curr, str);
            dfs(ret, tmp, n-2);
        }
    }
    
    public String concatenate(String str, String mid){
        int len = str.length();
        return str.substring(0, len/2) + mid + str.substring(len/2);
        
    }
}
