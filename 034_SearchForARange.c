/* Analysis - Binary Search
(1) After find the target, scan left and right to find the range
*/

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* searchRange(int* nums, int numsSize, int target, int* returnSize) {
    int low = 0, high = numsSize - 1;
    int i = 0, j = 0;
    int *ret = (int *)malloc(2*sizeof(int));
    * returnSize =2;
    ret[0] = -1;
    ret[1] = -1;
    //printf("ret[0] = %d, ret[1] = %d\n", ret[0], ret[1]);
    while(low <= high){
        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            i = mid;
            j = mid;
            while(i>=0){
                if(nums[i] != target)
                    break;
                i--;
            }
            while(j <= high){
                if(nums[j] != target)
                    break;
                j++;
            }
            ret[0] = i+1;
            ret[1] = j-1;
            //printf("ret[0] = %d, ret[1] = %d\n", ret[0], ret[1]);
            return ret;
        }
        else if(nums[mid] < target){
            low = mid + 1;
        }
        else{
            high = mid - 1;
        }
    }
    return ret;
}
