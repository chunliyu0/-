/* Analysis - two pointers
*/

void swap(int * n1, int * n2){
    int tmp = *n1;
    *n1 = *n2;
    *n2 = tmp;
}

void print(int * nums, int numsSize){
    for(int i = 0; i<numsSize; i++){
        printf("%d\t", nums[i]);
    }
}
void sortColors(int* nums, int numsSize) {
    if(nums==NULL || numsSize<=1) return;
    int i = 0, j = numsSize - 1, k = 0;
    
    while(k <= j ){
        if(k == i && nums[i] == 0){
            k ++;
            continue;
        }
        if(k == j && nums[j] == 2){
            return;
        }
      
        if(nums[k] == 0){
            swap(&nums[k], &nums[i]);
            i++;
            if(i==numsSize){
                return;
            }
        }
        else if(nums[k] == 2){
            swap(&nums[k], &nums[j]);
            j--;
            if(j==-1){
                return;
            }
        }
        else{
            k++;
        }
    }
}
