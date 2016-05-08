//http://blog.csdn.net/linhuanmars/article/details/22365957

public class Solution {
    public int[] plusOne(int[] digits) {//digits = {9,9,9}
        if(digits==null||digits.length==0)return null;
        int i = digits.length-1;
        while(i>=0&&digits[i]==9)//if digits = {1}, we should return {0};
            digits[i--]=0;
        if(i>=0){
            digits[i]=digits[i]+1;
            return digits;
        }
        int [] newDigits = new int[digits.length+1];
        newDigits[0] = 1;
        for(i=1;i<newDigits.length;i++)
            newDigits[i]=digits[i-1];
        return newDigits;
    }
}
