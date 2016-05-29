/* Analysis
(1) using % to get the last bit and using / to shift right.
(2) handling the overflow
*/

int reverse(int x) {
    int sign = 1, ret = 0;
    if(x<0){
        x=-x;
        sign = -1;
    }
    while(x!=0){
        if(ret != (ret*10+x%10)/10)
            return 0;//check the overflow
        ret = ret*10 + x%10;
        x = x/10;
    }
    return sign*ret;
}
