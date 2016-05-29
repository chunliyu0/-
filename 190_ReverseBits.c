/* Analysis
(1) shift right for 32 times, each time set the corresponding bit 2 times bigger
*/

uint32_t reverseBits(uint32_t n) {
    uint32_t ret = 0;
    int i = 0;
    while(i<32){
        ret = ret * 2 + n%2;
        n = n>>1;
        i++;
    }
    return ret;
}
