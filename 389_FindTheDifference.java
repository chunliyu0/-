/* Analysis - BitMap */

public class Solution {
    public char findTheDifference(String s, String t) {
        char [] arr1 = s.toCharArray();
        char [] arr2 = t.toCharArray();
        int[] bitmap = new int[26];
        
        for(int i = 0; i<arr1.length; i++){
            bitmap[arr1[i]-'a']++;
        }
        
        int idx = 0;
        for(int i = 0; i < arr2.length; i++){
            bitmap[arr2[i]-'a']--;
            if(bitmap[arr2[i]-'a'] == -1){
                idx = arr2[i]-'a';
                break;
            }
        }
        
        return (char)('a' + idx);
    }
}
