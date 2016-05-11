/* Analysis
 * use two pointer with one from the beginning and the other one from the end.
 */
 
int* twoSum(int* numbers, int numbersSize, int target, int* returnSize) {
    //Corner Cases
    if(numbersSize<2)return NULL;
    
    int i=0, j = numbersSize-1;
    int *ret;//cannot declare as int ret[2];
    
    while(i<j){
        if(numbers[i] + numbers[j] == target){
            ret[0] = i+1;
            ret[1] = j+1;
            *returnSize = 2;
            return ret;
        }
        else if(numbers[i] + numbers[j] < target){
            i++;
        }
        else{
            j--;
        }
    }
    *returnSize = 0;
    return NULL;
}
