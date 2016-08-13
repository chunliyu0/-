/* Analysis - DP[Bottom up]*/

public class Solution {
    public int integerBreak(int n) {
        if(n < 2 || n > 58)return 0;
        if(n==2)return 1;
        if(n==3)return 2;
        
        int [] ref = new int[59];
        ref[2] = 2;
        ref[3] = 3;
        for(int i = 2; i <= n-2; i++)
            for(int j = 2; j <= 3; j++){//all the numbers can be based on ref[2] and ref[3], just adjust ref[i]
                if(i+j <= 58)
                    ref[i+j] = Math.max(ref[i+j], ref[i]*ref[j]);
            }
        return ref[n];
    }
}
