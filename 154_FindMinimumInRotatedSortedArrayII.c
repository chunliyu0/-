/* Analysis
the only problem within the sorted duplicate array is to remove the duplicate on the right
*/

int findMin(int* nums, int numsSize) {
    if(nums[0] < nums[numsSize-1])return nums[0];
    
    int low = 0, high = numsSize - 1;
    while(low < high){
        int mid = low + (high - low)/2;
        
        if(nums[mid] < nums[high])
            high = mid; // the minimum is in the left part
        else if(nums[mid] > nums[high])
            low = mid + 1; // the minimum is in the righ part
        else{//the case when nums[mid] == nums[high]
            high --;//remove duplicate on the right
        }
    }
    return nums[low];
}
