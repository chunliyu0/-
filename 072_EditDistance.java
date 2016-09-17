/* Analysis - DP[Minimum]
(1) we need to match each possibility in both of the arrays, so 2D DP
(2) cost[i][j] = Math.min{cost[i][j-1] + 1, //insertion
                          cost[i-1][j] + 1, //deletion
                          cost[i-1][j-1] + (word1[i] == word2[j]? 0: 2); //editon
                         }
    }
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0 )
            return word2.length();
        if(word2 == null || word2.length() == 0 )
            return word1.length();
            
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[][] ref = new int[arr1.length + 1][arr2.length + 1];
        
        //initialization
        for(int i = 0; i <= arr1.length; i++){
            ref[i][0] = i;//deletion    
        }
        for(int j = 0; j <= arr2.length; j++){
            ref[0][j] = j;//insertion    
        }
        
        for(int i = 1; i <= arr1.length; i++){
            for(int j = 1; j <= arr2.length; j++){
                int insertions = ref[i][j-1] + 1;
                int deletions = ref[i-1][j] + 1;
                int editions = (arr1[i-1] == arr2[j-1] ?  ref[i-1][j-1]: ref[i-1][j-1] + 1);
                ref[i][j] = Math.min(Math.min(insertions, deletions), editions);
            }
        }
        
        return ref[arr1.length][arr2.length];
    }
}
