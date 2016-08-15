/* Analysis - DP_1D
(1) pay attention that the coins may not be sorted in advance
(2) To each amount, check the current combination of different coins.
*/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] ref = new int[amount + 1];
        ref[0] = 0;
        for(int i = 1; i <= amount; i++){
            ref[i] = amount + 1;//初始时设置为一个不可能的大值
        }
        
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i < coins[j]) continue;//面额太大，跳过
                ref[i] = Math.min(ref[i], ref[i-coins[j]] + 1);//比较当前面额值和已求得的面额
            }
        }
    
        return ref[amount] > amount ? -1: ref[amount];
    }
}
