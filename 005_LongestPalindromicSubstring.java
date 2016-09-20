/* Analysis - DP[Maximum]
(1) 2D array tracks all the palindrome from index i to index j
(2) fill from bottom right to upper left
*/

public class Solution {
    public String longestPalindrome(String s) {
        char [] arr = s.toCharArray();
        if(arr.length <= 1)return s;
        
        boolean[][] ref = new boolean[arr.length][arr.length];
        int start = 0, max = 0;
        for(int i = arr.length - 1; i >=0; i--){
            ref[i][i] = true;//one character is a palindrome
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] == arr[j] && (i+1 > j-1 || ref[i+1][j-1])){
                    ref[i][j] = true;
                    if(j-i > max){
                        start = i;
                        max = j-i;
                    }
                }
                    
            }
        }
        System.out.println(max);
        return s.substring(start, start + max + 1);
        
    }
}
