/* Analysis 
(1) take care of the overflow
(2) start from the LSB
*/

public class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if(m < n)
            return addStrings(num2, num1);
        
        String ret = "";
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int carry = 0, i, j;
        for(i = m-1, j = n-1; j >= 0; i--, j--){
            int sum = (arr1[i] - '0') + (arr2[j] - '0') + carry;
            ret = "" + sum % 10 + ret;
            carry = sum / 10;
        }
        
        while(i >= 0){
            int sum = (arr1[i] - '0') + carry;
            ret = "" + sum % 10 + ret;
            carry = sum / 10;
            i--;
        }
        if(carry == 1)
            ret = "1" + ret;
            
        return ret;
    }
}
