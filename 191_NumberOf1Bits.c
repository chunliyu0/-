/* Analysis
(1) check if the LSB == 1 --> (n&1)==1; if so, count++;
(2) move one bit right --> n = n>>1;
*/

int hammingWeight(uint32_t n) {
    int count=0;
    while(n>=1){
        if((n&1)==1)
            count++;
        n = n>>1;
    }
    return count;
}
