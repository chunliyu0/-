public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3)
            return 0;
        int [] ref = new int[A.length];
        ref[0] = 0;
        ref[1] = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i-1] != A[i-1] - A[i-2]){
                ref[i] = 0;
            }
            else{
                ref[i] = 1 + ref[i-1];
            }
        }
        
        int ret = 0;
        for(int i = 0; i < A.length; i++)
            ret += ref[i];
        return ret;
    }
}
