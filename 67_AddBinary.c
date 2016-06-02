/* Analysis
(1) assume there will be a carry for the MSB.
(2) ret[k] = (carry%2) +'0'; carry = (carry>>1);
(3) move teh pointer based on if there is carry.
*/

char* addBinary(char* a, char* b) {
    int len1 = strlen(a), len2 = strlen(b), carry = 0;
    int len = len1>len2 ? len1: len2;
    char * ret = malloc(len+2);
    
    ret[len+1] = '\0';//add the ending
    int i = len1-1, j = len2-1, k = len;
    while(i>=0 || j>=0){
        if(i>=0)carry += (a[i--] - '0');
        if(j>=0)carry += (b[j--] - '0');
        ret[k--] = (carry%2) +'0';
        carry = (carry>>1);
    }
    ret[0] = carry + '0';//decide the first character
    return ret + (carry ^ 1);//move the ret pointer (carry^1) step forward
}

