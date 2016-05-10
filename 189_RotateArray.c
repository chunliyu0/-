/* Analysis
(1) Reverse the whole array -> Reverse the first part + Reverse the second part.
(2) Consider the case when k is greater than numsSize. if k==numsSize, then the array keeps unchanged.
*/

void swap(int * i, int * j){
    int tmp = *i;
    *i = *j;
    *j = tmp;
}

void reverse(int *nums, int i, int j){
    while(i<j){
        swap(&nums[i], &nums[j]);
        i++;
        j--;
    }
}

void rotate(int* nums, int numsSize, int k) {
    k = k % numsSize;
    if(k==0)return;
    reverse(nums, 0, numsSize - 1);
    reverse(nums, 0, k-1);
    reverse(nums, k, numsSize-1);
}
