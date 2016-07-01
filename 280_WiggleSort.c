/* Analysis
(1) just check if the value at the odd index is the partial greatest one.
(2) take care of the case when it reaches the last one
*/

void swap(int * n1, int * n2){
    int tmp = *n1;
    *n1 = *n2;
    *n2 = tmp;
}

void wiggleSort(int* nums, int numsSize) {
    if(nums==NULL || numsSize < 2) return;
    for(int i = 1; i < numsSize; i+=2){
        if(i == numsSize-1){
            if(nums[i-1] > nums[i])
                swap(&nums[i-1], &nums[i]);
        }
        else{
            if(nums[i] >= nums[i-1] && nums[i] >= nums[i+1])
                continue;
            else{
                int max = (nums[i-1] < nums[i+1]? i+1: i-1);
                swap(&nums[max], &nums[i]);
            }
        }
    }
}
