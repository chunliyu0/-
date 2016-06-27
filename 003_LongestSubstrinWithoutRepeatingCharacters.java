public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)return 0;
        
        int max = 0, start = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){//the character shows up the first time
                map.put(ch,i);
            }
            else{//the character shows up again
                if(i - start > max){
                    max = i - start;
                }
                start = (map.get(ch) >= start ? map.get(ch)+1: start);
                //System.out.printf("ch = %c, start = %d\n",ch,start);
                map.put(ch,i);//update the index of the repeated character
            }
        }
        return s.length()-start > max? s.length()-start:max;
    }
}
