/* Analysis - Bit Manipulation */

public class Solution {
    public int integerReplacement(int n) {
        int count = 0;
        while(n != 1){
            if((n & 1) == 0){//if n is even
                n >>>= 1;//>> has the sign bit
            }
            else{//if n is odd
                if(n == 3 || Integer.bitCount(n-1) < Integer.bitCount(n+1))//the equal sign matters (011)
                    n--;
                else
                    n++;
            }
            count++;
        }
        return count;
    }
}
