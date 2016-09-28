/* Analysis
(1) take care of the overflow
(2) find out the scope, then the num
*/

public class Solution {
    public int findNthDigit(int n) {
        if(n < 10)return n;
        
        long count = 9, offset = 9, digits = 1;
        while(count <= n){
            offset *= 10;
            digits ++;
            count += offset * digits;
        }
        count -= offset * digits;
        
        long start = (int) Math.pow(10, digits - 1);
        long quotient = (n - count) / digits, rem = (n - count) % digits;
        long num = start - 1 + quotient;
        
        if(rem == 0)
            return (int)(num) % 10;
        else
            return Long.toString(num + 1).charAt((int)rem - 1) - '0';
    }
}
