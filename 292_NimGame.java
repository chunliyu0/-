/* Analysis - Math
(1) we will always win if we can leave 4 stones to the friend;
(2) on the other hand, if we are left 4 stones, we will always lose;
*/

public class Solution {
    public boolean canWinNim(int n) {
        return n%4 != 0;
    }
}
