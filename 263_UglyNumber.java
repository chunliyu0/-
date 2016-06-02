/* Analysis
                  x     y    z
Since ugly num = 2  * 3   * 5,  we can get rid of these dividers.
*/

public class Solution {
    public boolean isUgly(int num) {
        if(num<=0)
            return false;
        while(num%2==0){
            num /= 2;
        }
        while(num%3 == 0){
            num /= 3;
        }
        while(num%5 == 0){
            num /= 5;
        }
        if(num==1)
            return true;
        return false;
    }
}
