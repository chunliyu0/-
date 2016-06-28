/* Analysis
(1) each time we get a match, we update the index and compare the current min with the new min
(2) Since we go backward and the previous min is already compared, we are looking for the latter ones.
*/

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length < 2)return 0;
        
        int idx1=words.length, idx2=words.length, min = Integer.MAX_VALUE;
        for(int i = 0; i< words.length; i++){
            if(words[i].equals(word1)){
                idx1 = i;
                min = (Math.abs(idx2 - idx1)<min? Math.abs(idx2 - idx1):min);
            }
            else if(words[i].equals(word2)){
                idx2 = i;
                min = (Math.abs(idx2 - idx1)<min? Math.abs(idx2 - idx1):min);
            }
        }
        return min;
    }
}
