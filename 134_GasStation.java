/* Anlaysis - Greedy */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){//check the start one by one
            int tank = 0, j = i;
            while(j < gas.length + i){
                int idx = j % gas.length;
                tank += ( gas[idx] - cost[idx] );
                if(tank < 0){
                    break;
                }
                j++;
            }
            if(j == gas.length + i)
                return i;//go back to the start
            else if( i < j % gas.length){//jump out of the gap
                i = j % gas.length;
            }
        }
        return -1;
    }
}
