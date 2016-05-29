/* Analysis
n = 3^x;
log10(n) = log10(3^x);
log10(n) = x* log10(3);
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0)return false;
        double power = Math.log10(n)/Math.log10(3);
        return power - Math.floor(power) == 0;
    }
}
