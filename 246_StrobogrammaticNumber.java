/* Analysis - HashMap*/

public class Solution {
    public boolean isStrobogrammatic(String num) {
        char [] arr = num.toCharArray();
        
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('8', '8');
        
        for(int i = 0; i<(arr.length+1)/2; i++){
            int idx = arr.length -1 -i;
            if(!map.containsKey(arr[i]))
                return false;
            else if(map.get(arr[i]) != arr[idx])
                return false;
        }
        return true;
    }
}

/* Analysis
Construct result string "00 11 88 69 96"
*/
public class Solution {
    public boolean isStrobogrammatic(String num) {
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 69 96".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }   
}
