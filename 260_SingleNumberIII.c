/* Analysis - bitwise
(1) first differenciate the two single numbers from the double ones
(2) Since if the two numbers are different, they must be different at a certain bit. --> diff = n & ~(n-1)
(3) divide into different spheres
*/

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* singleNumber(int* nums, int numsSize, int* returnSize) {
    int *ret = (int*)malloc(2);
    ret[0] = 0;
    ret[1] = 0;
    int n = 0;
    
    for(int i = 0; i<numsSize; i++){
        n ^= nums[i];
    }
    
    n = n & ~(n-1);
    for(int i = 0; i<numsSize; i++){
       if((n & nums[i]) == 0){
           ret[1] ^= nums[i];
       }
       else{
           ret[0] ^= nums[i];
       }
    }
    *returnSize = 2;
    return ret;
}
