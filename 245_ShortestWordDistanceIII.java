public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = words.length, idx2 = words.length, min = Integer.MAX_VALUE;
        boolean flag = false;
        
        if(word1.equals(word2))
            flag = true;
            
        if(flag)
            for(int i = 0; i<words.length; i++){
                if(words[i].equals(word1)){
                    min = Math.min(min, Math.abs(i - idx1));
                    idx1 = i;
                }
            }
        else{
            for(int i = 0; i<words.length; i++){
                if(words[i].equals(word1)){
                    min = Math.min(min, Math.abs(i - idx2));
                    idx1 = i;
                }
                else if(words[i].equals(word2)){
                    min = Math.min(min, Math.abs(i - idx1));
                    idx2 = i;
                }
            }
        }
        return min;
    }
}
