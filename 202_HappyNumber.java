/* Analysis - Hashmap
(1) get the digit square sum of each number;
(2) check if it already shows up or it reaches to 1;
*/

public class Solution {
    public boolean isHappy(int n) {
        if(n<1) return false;
        
        Set<Integer> set = new HashSet<Integer>();//to check if the result is in a cycle (shows up before);
        
        while(true){
            int sum = 0;
            set.add((Integer)n);
            //get the sum of each original number;
            while(n!=0){
                int digit = n%10;
                sum += digit * digit;
                n = n/10;
            }
            if(sum==1)return true;
            if(set.contains(sum))return false;
            n = sum;
        }
    }
}
