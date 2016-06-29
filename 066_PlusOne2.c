/* Analysis
(1) Search from the end to find the 1st number which is not equal to 9 and increase it by 1
(2) Deal with the case when there is overflow (99999);
*/

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int i = digitsSize - 1;
    while(digits[i]==9){
        digits[i] = 0;
        i--;
    }
    
    if(i>=0){
        digits[i]=digits[i]+1;
        *returnSize = digitsSize;
        return digits;
    }
    else{
        int *ret = (int*)malloc((digitsSize + 1) * sizeof(int));
        for(i=digitsSize-1;i>=0;i--)
            ret[i+1] = digits[i];
        ret[0] = 1;
        *returnSize = digitsSize + 1;
        return ret;
    }
}
