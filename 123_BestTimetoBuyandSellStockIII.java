/* Analysis - DP
(1) the local maximum depends on the value before.
(2) the global maximum if the result of one transaction in the left part and the other transaction on the right part.
*/

public class Solution {
    public int maxProfit(int[] prices) {
        int ret = 0, max = 0;
        if(prices == null || prices.length < 2)return ret;
        
        int low = 0;
        int [] left = new int[prices.length];
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > prices[low]){
                max = Math.max(max, prices[i] - prices[low]);
            }else{
                low = i;
            }
            left[i] = max;
        }
        
        max = 0;
        int high = prices.length - 1;
        int [] right = new int[prices.length];
        for(int i = prices.length - 2; i >= 0; i--){
            if(prices[i] < prices[high]){
                max = Math.max(max, prices[high] - prices[i]);
            }else{
                high = i;
            }
            right[i] = max;
        }
        
        max = 0;
        for(int i = 0; i<prices.length; i++){
            if(left[i] + right[i] > max)
                max = left[i] + right[i];
        }
        
        return max;
    }
}
