/* Analysis
(1) pow(x, n) = pow(x, n/2) * pow(x, n/2) when n%2==0;
(2) a lot of corner cases especially when n==INT_MIN because INT_MIN = -(1+INT_MAX), besides, pow(x, INT_MIN) == 0;
*/

double myPow(double x, int n) {
    if((n<=INT_MIN || n>=INT_MAX) && (x>1 || x<-1)) return 0; //pow(x, INT_MIN) == 0;
    if(x==1)return 1;
    if(x==-1)return n%2==0?1:-1;
    if(n==0)return 1;
    if(n==1)return x;
    if(n<0) return myPow(1/x, -n);
    
    double y = myPow(x, n/2);
    if(n%2==0)
        return y * y;
    else
        return y * y * x;
}
