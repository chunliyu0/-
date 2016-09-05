/* Analysis - Greedy
(1) the sell and buy can happen on the same day
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2)return 0;
        
        int max = 0, pre = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > pre){//buy the stock
                max += (prices[i] - pre);
            }
            pre = prices[i];
        }
        return max;
    }
}
