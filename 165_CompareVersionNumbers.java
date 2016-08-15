/* Analysis
(1) look at 2.5 and 2.37
(2) pay attention that there may be more than 1 '\\.'
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        char [] arr1 = version1.toCharArray();
        char [] arr2 = version2.toCharArray();
        
        for(int i = 0, j = 0; i<arr1.length || j<arr2.length; i++, j++){
            int val1 = 0, val2 =0;
            while(i < arr1.length && arr1[i] != '.'){
                val1 = val1*10 + (arr1[i]-'0');
                i++;
            }
            while(j < arr2.length && arr2[j] != '.'){
                val2 = val2*10 + (arr2[j]-'0');
                j++;
            }
            if(val1 == val2){
                continue;
            }
            return val1 > val2 ? 1: -1;
        }
        
        return 0;
    }
}
