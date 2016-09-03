/* Analysis - DP 
(1) if n == 1, we should also count the case n == 0 (n = 0 then x == 10^0 == 1)
*/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)return 1;
        
        int [] ref = new int[n+1];
        ref[0] = 1;
        for(int i = 1; i <= n; i++){
            ref[i] = 9;
        }
        
        int num = 9;
        for(int i = 2; i<=n; i++){
            ref[i] = ref[i-1] * (num--);
        }
        
        int ret = 0;
        for(int i = 0; i <= n; i ++)
            ret += ref[i];
        return ret;
    }
}
