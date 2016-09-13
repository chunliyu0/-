/* Analysis - DFS */

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new ArrayList<>();
        dfs(ret, "", num, 0, 0, target);
        return ret;
    }
    
    public void dfs(List<String> ret, String curr, String str, long prev, long eval, int target){//the target may be negative
        if(str == null || str.length() == 0){
            if(eval == target)
                ret.add(curr);
            return;
        }
        //System.out.println(curr + ", " + str + ", " +prev);
        char [] arr = str.toCharArray();
        for(int i = 1; i <= arr.length; i++){
            String str1 = str.substring(0,i);
            String str2 = str.substring(i);
            long val = Long.parseLong(str1);
            
            if(curr.length() == 0){ // the start of the expression
                dfs(ret, curr + str1, str2, val, val, target); 
            }
            else{// the current val can be added, substracted, or multiplied to the previous number
                dfs(ret, curr + "+" + str1, str2, val, eval + val, target);//addition
                dfs(ret, curr + "-" + str1, str2, -1*val, eval - val, target);//substraction
                dfs(ret, curr + "*" + str1, str2, prev*val, (eval - prev) + prev * val, target);//multiplication
            }
            if(str1.charAt(0) == '0')
                return;
        }
        
        
    }
}
