/* Analysis
(1) transfer the string to the corresponding int array;
(2) if the number is greater than its previous one, then get their diff
(3) check if the last number has already been paired
*/

int romanToInt(char* s) {
    int ret = 0, i;
    int *arr = (int*)malloc( strlen(s) * sizeof(int));
    
    //transfer the string to the corresponding int array;
    for(i = 0; i < strlen(s); i++){
        switch(s[i]){
            case 'M': arr[i]=1000; break;
            case 'D': arr[i]=500; break;
            case 'C': arr[i]=100; break;
            case 'L': arr[i]=50; break;
            case 'X': arr[i]=10; break;
            case 'V': arr[i]=5; break;
            case 'I': arr[i]=1; break;
        }
    }
    //if the number is greater than its previous one, then get their diff, else add up;
    for(i = 1; i < (int)strlen(s); i++){
        if(arr[i]>arr[i-1]){
            ret+= arr[i]-arr[i-1];
            i++;
        }
        else{
            ret+= arr[i-1];
        }
    }
    //check if the last number has already been paired
    if(i == strlen(s)){
         ret += arr[i-1];
    }
    return ret;
}
