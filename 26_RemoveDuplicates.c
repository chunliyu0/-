//use a pointer to count the non-duplicate position.

int removeDuplicates(int* nums, int numsSize) {
    if(numsSize<2)return numsSize;
    
    //count is to save the distinguished number while i is used to traverse the array.
    record the last non-duplicate position;
    int count = 0, i;
    for(i=1;i<numsSize;i++){
        if(nums[i]!=nums[i-1]){
            nums[++count]=nums[i];
        }
    }
        
    return count+1;
}
