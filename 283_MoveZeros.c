void moveZeroes(int* nums, int numsSize) {
    if(numsSize < 2)return;
        
    int i, j = 0;//j points to zeroes from the beginning, i tries to find nonzeros in order.
    int temp;
    //if i == j, and nums[i]!=0, j will go one step further after switch
    for (i = 0; i < numsSize; i++) {
          if (nums[i] != 0) {
              temp = nums[i];
              nums[i] = nums[j];
              nums[j++] = temp;
            }
        }
}
