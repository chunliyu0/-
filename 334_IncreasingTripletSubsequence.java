/* Analysis
(1) track the smallest and smaller ones
*/

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE, smaller = Integer.MAX_VALUE;
        for(int num: nums){
            if(num <= smallest)//the smallest one is assgined first
                smallest = num;
            else if(num <= smaller)
                smaller = num;
            else
                return true;
        }
        return false;
    }
}
