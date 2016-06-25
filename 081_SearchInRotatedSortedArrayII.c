/* Analysis
(1) deal with the pure part first and decrease the size of the searching array
(2) in the special case, nums[low] == nums[mid], they may not in the same part, we need to differenciate it by checking if nums[low] == nums[high]
*/

bool search(int* nums, int numsSize, int target) {
    if(nums==NULL || numsSize == 0) return false;
    
    int low = 0, high = numsSize-1;
    while(low <= high){
        int mid = low + (high - low)/2;
        if(target == nums[mid])return true;
        
        if(nums[low] < nums[mid]){
            if(target >= nums[low] && target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        else if(nums[low] > nums[mid]){
            if(target > nums[mid] && target <= nums[high])
                low = mid + 1;
            else
                high = mid - 1;
        }
        else{//the case when nums[low] == nums[mid]
            if(nums[low] == nums[high])
                high --;
            else
                low ++;
        }
    }
    return false;
}
