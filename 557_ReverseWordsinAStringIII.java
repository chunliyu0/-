/* Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
   Example 1: Input: "Let's take LeetCode contest"    Output: "s'teL ekat edoCteeL tsetnoc"
   Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder ret = new StringBuilder();
        int size = arr.length;
        for(String str: arr){
            ret.append(reverse(str));
            ret.append(" ");
        }
        return ret.toString().trim();
    }
    
    public String reverse(String str){
        Stack<Character> stk = new Stack();
        char[] tmp = str.toCharArray();
        for(char ch: tmp){
            stk.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
			sb.append(stk.pop());
		}
        return  sb.toString();
    }
}
