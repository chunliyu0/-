/* Analysis
(1) Traverse the sorted array with n distinct numbers and find out y which can get y*y == x.
(2) Corner cases: x<0;
*/

int mySqrt(int x) {
    if(x<0)return -1;
    if(x==0||x==1)return x;
    
    int mid, low = 1, high = x; 
    while(low<=high){
        mid = low + (high-low)/2; //(low + high) may lead to overflow
        if(mid == x / mid) //mid*mid==x in which there may be an overflow for mid*mid, besides, x/mid can process cases like x==11
            return mid;
        else if(mid < x / mid)//
            low = mid + 1;
        else
            high = mid - 1;
    }
    return high;
}


   
