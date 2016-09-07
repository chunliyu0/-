/* Analysis - DP 
(1) two rounds
(2) if two kids has the same rand, it does not matter which one gets more candies
*/

public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)return 0;
        
        int [] counts = new int[ratings.length];
        
        //initialize
        for(int i = 0; i<counts.length; i++){
            counts[i] = 1;
        }
        
        for(int i = 1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1])
                counts[i] = counts[i-1] + 1;
        }
        
        for(int i = ratings.length - 1; i > 0; i--){
            if(ratings[i-1] > ratings[i] && counts[i-1] <= counts[i])//one more restriction
                counts[i-1] = counts[i] + 1;
        }
        
        //sum up
        int sum = 0;
        for(int i = 0; i<counts.length; i++){
            sum += counts[i];
            System.out.printf("%d, ", counts[i]);
        }
        return sum;
    }
}
