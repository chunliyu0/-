/* Analysis
(1) get the product the first part before the current position during the first traverse
(1) get the product the second part after the current position during the second traverse
*/

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* productExceptSelf(int* nums, int numsSize, int* returnSize) {
    
    int *ret = (int*)malloc(numsSize*sizeof(int));
    int prod = 1, i;
   
    for(i=0; i<numsSize; i++){
        ret[i] = prod;
        prod *= nums[i];
    }
   
    for(i=numsSize-1,prod = 1; i>=0;i--){
        ret[i] *= prod;
        prod *= nums[i];
    }
   
    *returnSize = numsSize;
    return ret;
}
