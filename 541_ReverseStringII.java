/* Given a string and an integer k, you need to reverse the first k characters for every 2k characters 
   counting from the start of the string. If there are less than k characters left, reverse all of them. 
   If there are less than 2k but greater than or equal to k characters, then reverse the first k characters 
   and left the other as original.
   Example: Input: s = "abcdefg", k = 2    Output: "bacdfeg"

   Restrictions: The string consists of lower English letters only.
                 Length of the given string and k will in the range [1, 10000]
*/

class Solution {
    public String reverseStr(String s, int k) {
        int size = s.length();
        StringBuilder sb = new StringBuilder();
        
        int window = 2*k, quotient = size / window, remainder = size % window;
        for(int i = 0; i < quotient; i += 1){
            sb.append(reverse(s.substring(i*window, i*window+k))); 
            sb.append(s.substring(i*window+k, (i+1)*window));
        }
        
        if(remainder < k)
            sb.append(reverse(s.substring(quotient * window)));
        else{
            sb.append(reverse(s.substring(quotient * window, quotient * window + k)));
            sb.append(s.substring(quotient * window + k));
        }
            
        return sb.toString();
    }
    
    public String reverse(String str){
        char[] arr = str.toCharArray();
        Stack<Character> stk = new Stack<Character>();
        for(char ch: arr)
            stk.push(ch);
        
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.toString();
    }
}
