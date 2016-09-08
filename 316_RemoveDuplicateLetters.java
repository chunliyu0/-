/* Analysis - Stack
(1) for each character, we remove the characters that are larger and will show up latter
*/

public class Solution {
    public String removeDuplicateLetters(String s) {
        char [] arr = s.toCharArray();
        int [] bitmap = new int[26];
        boolean [] visited = new boolean[26];
        Stack<Character> stk = new Stack<>();
        
        //initialize the bitmap
        for(char ch: arr){
            bitmap[ch - 'a'] ++;
        }
        
        //traverse the array
        for(char ch: arr){
            bitmap[ch - 'a']--;
            if(visited[ch - 'a'])continue;
            
            // the restriction when the repeted letters can be removed is that it will up later
            while(!stk.isEmpty() && stk.peek() > ch && bitmap[stk.peek() - 'a'] > 0){//pop out of the stack
                visited[stk.peek() - 'a'] = false;
                stk.pop();
            }
            stk.push(ch);
            visited[ch - 'a'] = true;
        }
        
        //integrate the result
        StringBuilder sb = new StringBuilder();
        for(char ch: stk){
            sb.append(ch);
        }
        return sb.toString();
    }
}
