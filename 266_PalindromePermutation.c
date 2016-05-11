/* Analysis
use hashmap to count the number of each word, if the odd numbers are greater than 1, it's not palindrome */

public class Solution {
    public boolean canPermutePalindrome(String s) {
        // Corner Cases
        if(s==null || s.length()<2)return true;
        
        int numOdd = 0;
        char ch;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        // Count each distinguished characters
        for(int i = 0; i<s.length();i++){
            ch = s.charAt(i);
            if(map.containsKey(ch) && (map.get(ch)==1))
                map.put(ch, 0);
            else
                map.put(ch, 1);
        }
        
        //Chech if the number of odd character is greater than 1
        for (Integer value : map.values()) {
            if(value==1)
                numOdd++;
            if(numOdd>1)
                return false;
        } 
        return true;
    }
}
