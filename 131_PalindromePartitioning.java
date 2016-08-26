/* Analysis - DFS */

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<List<String>>();
        dfs(ret, new ArrayList<String>(), s);
        return ret;
    }
    
    public void dfs(List<List<String>> ret, List<String> curr, String str){
        int len = str.length();
        if(str==null || len == 0){
            ret.add(new ArrayList<String>(curr));
            return;
        }
        
        for(int i = 1; i<=len; i++){
            String tmp = str.substring(0,i);
            if(isPalindrome(tmp)){
                //List<String> list = new ArrayList<String>(curr);
                curr.add(tmp);
                dfs(ret, curr, str.substring(i, len));
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        int i = 0, j = str.length()-1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
