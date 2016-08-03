/* Analysis - binary tree */

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1, max = n, mid = max;
        
        int res = guess(mid);
        while(res != 0){
            if(res == -1)
                max = mid;
            else
                min = mid;
            mid = min + (max - min)/2;
            res = guess(mid);
        }
        return mid;
    }
}
