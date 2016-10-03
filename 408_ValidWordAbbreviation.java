/* Analysis 
(1) take care of the case the number is of more than 2 digits
(2) take care of the case when the number has a leading 0
*/

public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] arr1 = word.toCharArray();
        char[] arr2 = abbr.toCharArray();
        
        int count = 0, j = 0;
        for(int i = 0; i < arr2.length; i++){
            if(arr2[i] >= 'a' && arr2[i] <= 'z'){
                j += count;
                if(j >= arr1.length || arr1[j] != arr2[i])
                    return false;
                    
                count = 0;
                j++;
            }
            else{
                if(count == 0 && arr2[i] == '0')
                    return false;
                count = count * 10 + ( arr2[i] - '0' );
            }
        }
        
        return count == 0? true: j+count==arr1.length;
    }
}
