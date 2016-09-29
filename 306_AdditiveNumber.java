/* Analysis - DFS */

public class Solution {
    public boolean isAdditiveNumber(String num) {
        for(int i = 1; i <= num.length()-2; i++){
            for(int j = i+1; j<=num.length()-1; j++){
                if(dfs(num, 0, i, j))return true;
            }
        }
        return false;
    }
    
    public boolean dfs(String num, int start, int i, int j){
        if(num.charAt(start) == '0' && i - start > 1 || num.charAt(i) == '0' && j - i > 1)return false;
        Long val1 = Long.valueOf(num.substring(start, i));
        Long val2 = Long.valueOf(num.substring(i, j));
        
        String str = Long.toString(val1 + val2);
        if(num.substring(j).indexOf(str)!=0)return false;
        if(j + str.length() == num.length())return true;
        return dfs(num, i, j, j + str.length());
    }
}
