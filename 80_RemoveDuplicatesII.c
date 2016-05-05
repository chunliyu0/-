//move the valid numbers forward

int removeDuplicates(int* nums, int numsSize) {
    //critical conditions
    if(numsSize<3) return numsSize;
    
    //count is the the actual size after adjustion while i is used to traverse the array
    int count = 1, i;
    for(i=2; i<numsSize; i++) {
        if(nums[i]!=nums[count-1])// 
            nums[++count] = nums[i];
    }
    
    return count+1;
}
