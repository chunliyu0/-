/* Analysis - Binary Search
find the thredsheld.
*/

// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

int firstBadVersion(int n) {
    int low = 1, high = n;
    
    while(low < high){
        int mid = low + (high - low)/2;
        if(isBadVersion(mid))
            high = mid;
        else
            low = mid + 1;
    }
    return high;
}
