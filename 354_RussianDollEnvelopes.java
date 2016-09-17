/* Analysis - DP[Maximu]
(1) 俄罗斯娃娃
(2) sort first, then solve as we do in LIS
*/

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0)return 0;
        
        //preprocess - sort by the width
        Comparator<int[]> comparator = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        };
        Arrays.sort(envelopes, comparator);
        
        //initialize the ref array
        int[] ref = new int[envelopes.length];
        for(int i = 0; i<envelopes.length; i++){
            int max = 0; //the capacity of envelopes[i]
            for(int j = 0; j<i; j++){
                if(envelopes[j][0] == envelopes[i][0])break;
                if(envelopes[i][1] > envelopes[j][1] && ref[j] > max)
                    max = ref[j];
            }
            ref[i] = max + 1;
        }
        
        int n = 0;
        for(int i = 0; i<ref.length; i++){
            if(n < ref[i])
                n = ref[i];
        }
        return n;
    }
}
