/* Analysis
Since each ugly number is the product of the previours ugly number * 2 or 3 or 5, 
here we will use i, j, k to track if the corresponding ugly number is already been used.
*/

int nthUglyNumber(int n) {
    if(n == 1) return 1;
    
    int * nums = (int *) malloc(n*sizeof(int));
    nums[0] = 1;
    
    int i = 0, j = 0, k = 0, index = 1;
    
    while(index < n){
        //get the min(nums[i]*2, nums[j]*3, nums[k]*5);
        int min = nums[i]*2 < nums[j]*3 ? nums[i]*2: nums[j]*3;
        min = min < nums[k]*5? min: nums[k]*5;
        nums[index++] = min;
        
        //here we cannot use if else if, otherwise 6 will be count for twice.
        if(min == nums[i]*2)
            i++;
        if(min == nums[j]*3)
            j++;
        if(min == nums[k]*5)
            k++;
    }
    
    return nums[index-1];
}
