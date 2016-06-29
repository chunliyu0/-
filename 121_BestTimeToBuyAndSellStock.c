/* Analysis
(1) get the min to the start and update start on the way.
*/

int maxProfit(int* prices, int pricesSize) {
    int max = 0, start = 0;
    
    for(int i = 1; i < pricesSize; i++){
        max = (prices[i] - prices[start]>max ? prices[i] - prices[start]: max);
        start = (prices[i] < prices[start] ? i: start);
    }
    
    return max;
}
