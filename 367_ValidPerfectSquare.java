/* Analysis - Binary Search
(1) be careful of overflow, the Integer.MAX_VALUE = 32768
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)return true;
        long low = 1, high = num/2, lnum = (long)num;
        
        while(low <= high){
            long mid = low + (high - low)/2;
            if(mid * mid == lnum)return true;
            else if(mid * mid > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}
