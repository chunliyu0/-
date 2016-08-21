/* Analysis
(1) count how many 5s in the scope of n (because the number of 2s is always greater than that of 5s)
(2) shift left by 2 bits is equal to times 4;
(3) first we move all the regular 5s
    second we move all the additional 5s brought by 25
    then we move all the additioal 5s brought by 125..125*5..125*5*5..125*5*5*5
*/

public class Solution {
    public int trailingZeroes(int n) {
        long divisor = 5;
        long ret = 0;
        while(divisor<=n){
            //System.out.println("divisor = " + divisor + ", divisor << 2 = " + (divisor << 2));
            ret +=  n/divisor ;
            divisor = divisor * 5;
        }
        return (int)ret;
    }
}
