/* Analysis
(1) Similar to the single number problem
(2) and all the numbers in the range, then all the numbers are doubled except the missing one.

*/

int missingNumber(int* nums, int numsSize) {
    if(nums==NULL || numsSize == 0)return 0;
    
    int ret = 0;//n & 0 = n
    for(int i = 0; i<=numsSize; i++){
        ret ^= i;
    }
    
    for(int i = 0; i<numsSize; i++){
        ret ^= nums[i];
    }
    return ret;
}
