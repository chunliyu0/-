void moveZeroes(int* nums, int numsSize) {
    if(numsSize < 2)return;
        
    //i traverses the array and tries to find nonzeros while j points to the 1st zero spot.
    int i, j = 0, temp;

    //if i == j nothing will be changed with the element swapping with itself
    //else i will move faster and the gap between i and j are 0's
    for (i = 0; i < numsSize; i++) {
          if (nums[i] != 0) {
              //Swap nums[i] and nums[j]
              temp = nums[i];
              nums[i] = nums[j];
              nums[j] = temp;
              j++;
            }
        }
}
