/* Analysis
(1) Naive way is to deduct divisor from dividend until dividend is less than zero;
(2) The more efficient way is to decrease the dividend and double the divisor at the same time;
*/

int divide(int dividend, int divisor) {
    if(divisor == 0 ) return dividend>0? INT_MAX: INT_MIN;
    if(dividend == 0 ) return 0;
    if(dividend == INT_MIN && divisor == -1) return INT_MAX;//deal with the overflow
    
    int sign =(dividend<0 && divisor<0 || dividend>0 && divisor>0) ? 1:-1;//get the sign
    unsigned int a = abs((unsigned int)dividend), b = abs((unsigned int)divisor);//get the absolute value
    if(a == b) return sign;
    
    int ret = 0, i = 1;
    while(a >= b){
        ret += i;
        a -= b;
        b <<= 1; // b *= 2
        i <<= 1;
        if(a < b){
            b = abs((unsigned int)divisor);
            i = 1;
        }
    }
    return (sign == 1)? ret: ~ret+1; //~ret + 1 is the corresponding negative number of ret;
}
