public class Solution {
    public int findComplement(int num) {
        int ret = 0, n = 0;
        
        while(num > 0){
            int bit = ((num & 1) == 1 ? 0: 1);
            ret = (bit << n) + ret;
            num = (num >> 1);
            n ++;
        }
        
        return ret;
    }
}
