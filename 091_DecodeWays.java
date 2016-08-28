/* Analysis - DP
(1) numDecodings(i) = numDecodings(i-1) + numDecodings(i-2)
(2) it is similare to Fibnacci and climbing stairs;
(4) 27 can only be decoded as BG, 0 cannot be decoded
*/

public class Solution {
    public int numDecodings(String s) {
        char [] arr = s.toCharArray();
        if(s == null || arr.length == 0 || arr[0] == '0')return 0;
           
        int count0 = 1,  count1 = 1, curr = 1;
        for(int i = 1; i < arr.length; i++){
            char [] num = {arr[i-1], arr[i]};
            if(arr[i] == '0'){//cannot exist alone
                if(isValid(num)) curr = count0;
                else return 0;
            }
            else{//can exist alone
                curr = count1;
                if(isValid(num))
                    curr += count0;
            }
            
            count0 = count1;
            count1 = curr;
        }
    
        return curr;
    }
    
    public boolean isValid(char[] num){
        if(num[0] == '0' || num[0] > '2')return false;
        int val = (num[0]-'0')*10 + (num[1] - '0');
        if(val >= 10 && val <= 26)return true;
        return false;
    }
}
