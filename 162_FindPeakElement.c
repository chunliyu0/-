/* Analysis
(1) Traverse the whole array to check if nums[i]>nums[i-1] && nums[i]>nums[i+1];
(2) the first and the last ones should be handled separately.
*/

int findPeakElement(int* nums, int numsSize) {
    if(numsSize==0)return -1;
    if(numsSize==1)return 0;
    if(nums[0]>nums[1])return 0;//handle the 1st element
    if(nums[numsSize-1]>nums[numsSize-2])return numsSize-1;//handle the last element
    
    for(int i = 1; i< numsSize-1; i++){
        if(nums[i]>=nums[i-1] && nums[i]>=nums[i+1])
            return i;
        if(nums[i]>nums[i+1])//save the time to check nums[i+1]
            i++;
    }
    return -1;
}
