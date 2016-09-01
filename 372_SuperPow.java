//https://www.hrwhisper.me/leetcode-super-pow/
/* Analysis
(1) Consider Overflow
*/

public class Solution {
    int mod = 1337;
    
    public int superPow(int a, int[] b) {
        int ret = 1, base = a%mod;
        
        for(int i = b.length-1; i>=0; i--){
            ret = ret * myPow(base, b[i]) % mod;
            base = myPow(base, 10);
        }
        return ret;
    }
    
    public int myPow(int base, int exp){
        int power = 1;
        while(exp > 0){
            if((exp & 1) != 0)// the exponent is an odd nubmer
                power = (power * base)%mod;
            base = (base*base) % mod;
            exp >>= 1;
        }
        return power;
    }
}
