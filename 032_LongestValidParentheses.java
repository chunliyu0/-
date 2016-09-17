/* Analysis - DP[Maximum] */

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) return 0;
        
        char[] arr = s.toCharArray();
        int [] ref = new int[arr.length];//the current character is included
        ref[0] = 0;
        
        int max = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] == ')'){
                int j = i - ref[i-1] - 1;//the index which is supposed to pair with i
                if(j >= 0 && arr[j] == '('){ //overflow
                    ref[i] = ref[i-1] + 2;
                    if(j - 1 >= 0)//overflow
                        ref[i] += ref[j-1];
                }
            }
            if(ref[i] > max)
                max = ref[i];
        }
                
        return max;
    }
}
