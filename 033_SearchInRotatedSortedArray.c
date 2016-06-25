/* Analysis
check whether mid is in the left part or the right part, deal with the pure part first and decrease the searching array gradually.
*/

int search(int* nums, int numsSize, int target) {
    int low = 0, high = numsSize - 1;
    
    while(low <= high){
        int mid = low + (high - low)/2;
        if(target == nums[mid])return mid;
        
        if(nums[low] <= nums[mid]){
            if(target >= nums[low] && target <= nums[mid])
                high = mid -1;
            else// deal with mixed case
                low = mid + 1;
        }
        else{ 
            if(target > nums[mid] && target <= nums[high])
                low = mid + 1;
            else// deal with mixed case
                high = mid - 1;
            
        }
    }
    return -1;
    
}

    
