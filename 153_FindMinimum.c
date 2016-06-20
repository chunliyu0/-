/* Analysis - Binary Search
(1) assume there is reversion, that is nums[low] > nums[high]; try to find the watershed
(2) if the first element is smaller than the last one, there is no reversion.
*/

int findMin(int* nums, int numsSize) {
    int low = 0, high = numsSize-1, mid = 0;
    
    while(nums[low] > nums[high]){
        mid = low + (high-low)/2;
        if(nums[low] == nums[mid]){
            return nums[mid+1];
        }
        else if(nums[low] < nums[mid]){
            low = mid;
        }
        else if(nums[low] > nums[mid]){
            high = mid;
        }
    }
    return nums[low];
}
