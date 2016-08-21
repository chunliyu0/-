/* Analysis 
(1) find the candidate, then all the others cannot be the result
(2) check if it is the real celebrity.
    case 1: it does not know anyboday, buy no body knows it
    case 2: it knows some people and every one knows her.
*/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cand = 0;//assume the first one is the candidate since there is only one candidate
        for(int i = 1; i<n; i++){
            if(knows(cand, i) || !knows(i, cand))
                cand = i;
        }
        
        for(int i = 0; i<cand; i++) 
            if(knows(cand, i) || !knows(i, cand)) 
                return -1; 
        return cand;
    }
}
