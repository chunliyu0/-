/* Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
   judge if this robot makes a circle, which means it moves back to the original place.
   The move sequence is represented by a string. And each move is represent by a character. 
   The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
   The output should be true or false representing whether the robot makes a circle.
   Example 1:
       Input: "UD"     Output: true
   Example 2:
       Input: "LL"     Output: false
*/

class Solution {
    public boolean judgeCircle(String moves) {
        if(moves.length() % 2 != 0)
            return false;
        
        char [] arr = moves.toCharArray();
        int countR = 0, countD = 0;
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            if(ch == 'L')
                countR--;
            else if(ch == 'R')
                countR++;
            else if(ch == 'U')
                countD--;
            else
                countD++;
        }
        if(countR == 0 && countD == 0)
            return true;
        
        return false;
    }
}
