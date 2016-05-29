/* Analysis
(1) put aside the last digit, the number has the same number of 1 bits as the number when it shifts one bit right.
(1) then add 1 more bit if the last digit is 1;
*/

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* countBits(int num, int* returnSize) {
    int *ret = (int*)malloc((num+1)*sizeof(int));//apply for memory
    
    ret[0] = 0;
    for(int i = 1; i<= num; i++){
          ret[i] = ret[i>>1] + i%2;
    }
    *returnSize = num + 1;
    return ret;
}
