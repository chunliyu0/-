//use a pointer to count the non-duplicate position.

int removeDuplicates(int* nums, int numsSize) {
    if(nums==NULL)return -1;
    if(numsSize<2)return numsSize;
    
    int count = 0, i;//record the last non-duplicate position;
    for(i=1;i<numsSize;i++){
        if(nums[i]!=nums[i-1]){
            nums[++count]=nums[i];
        }
    }
    /*for(i=count+1;i<numsSize;i++)
        nums[i]=0;*/
        
    return count+1;
}
