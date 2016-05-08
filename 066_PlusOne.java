//http://blog.csdn.net/linhuanmars/article/details/22365957

//Special case: digits = {9,9,9} in which we need to create a new array with one more memory unit
public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null||digits.length==0)return null;
        
        //the most significant digit is on the left, so we should start from the right
        int i = digits.length-1;
        
        //keep searching from the least significant digit until we find the digit less than 9, and set the digits with 9 with 0.
        //then plus one at the corresponding digit    
        while(i>=0 && digits[i]==9)
            digits[i--]=0;
        
        //if some of the digits from the most significant digit are less 9
        if(i>=0){
            digits[i]=digits[i]+1;
            return digits;
        }
        
        //else the original array has 9 at every digit, a new array with one more space needs to be created
        int [] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(i=1;i<newDigits.length;i++)
            newDigits[i]=digits[i-1];
        return newDigits;
    }
}
