/* Analysis
(1) the permutations are in increasing order
(2) directly get the kth permutation
(3) set each bit from the left one by one
(4) assume k is from 0 to k-1
*/

public class Solution{
    public String getPermutation(int n, int k){
        char [] ret = new char[n];
        
        int fact = 1;//get the factorial reference
        for(int i = 1; i <= n; i++){   
            fact *= i ;
            ret[i - 1] = (char)('0' + i);//initialize the array
        }
        
        k--;
        for(int i = 0; i < n; i++){//deal with each bit
            fact = fact/(n - i);
            int m = k/fact;//find out the mth bigest number from current postion i
            reArrange(ret, i, i+m);
            k = k % fact;
        }
        
        return new String(ret);
    }
    
    public void reArrange(char[] arr, int start, int end){
        char tmp = arr[end];
        for(int i = end - 1; i >= start; i--){
            arr[i+1] = arr[i];
        }
        arr[start] = tmp;
    }
}
