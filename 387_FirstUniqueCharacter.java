/* Analysis - HashMap */

public class Solution {
    public int firstUniqChar(String s) {
        char [] arr = s.toCharArray();
        int [] bitmap = new int[26];
        
        for(int i=0; i<arr.length; i++){
            bitmap[arr[i] - 'a'] ++;
        }
        
        for(int i=0; i<arr.length; i++){
            if(bitmap[arr[i] - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
