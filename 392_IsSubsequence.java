/* Analysis - Array */

public class Solution {
    public boolean isSubsequence(String s, String t) {
        char [] arr1 = s.toCharArray(), arr2 = t.toCharArray();
        int start = 0, i = 0, j = 0;
        for(i = 0; i < arr1.length; i++){
            System.out.println(arr1[i]);
            for(j = start; j < arr2.length; j++){
                if(arr2[j] == arr1[i]){
                    start = j + 1;
                    break;
                }
            }
            if(j == arr2.length)return false;
        }
        return true;
    }
}
