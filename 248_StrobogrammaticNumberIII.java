/* Analysis - DFS
(1) cannot use Integer.parseInt for comparison of two strings because the two strings can be extremely large
(2) the dfs start from two outer characters because the left could not be 0
    when low is less than 10, we should include 0, 1, 8 manually
*/

public class Solution {
    int count = 0;
    String [] mids = {"0", "1", "8"};
    String [] ref = {"00", "11", "69", "96", "88"};
    
    public int strobogrammaticInRange(String low, String high) {
        if(high.length() == 1){
            for(int i = 0; i<mids.length; i++)//to get rid of the 0s in the beginning
                if(isValid(mids[i], low, high))
                    count++;
            return count;
        }
        for(int i = 1; i<ref.length; i++){//to get rid of the 0s in the beginning
            dfs(ref[i], low, high);
        }
        
        if(low.length() <= 2 && Integer.parseInt(low) <= 10)
            count += 3;
        return count;
    }
    
    public void dfs(String curr, String low, String high){//spand from inside
        if(curr.length() > high.length())return;
        if(isValid(curr, low, high))count++;
        
        for(String mid: mids){
            if(isValid(concatenate(curr, mid), low, high))
                count++;
        }
        
        for (String str: ref){
            String tmp = concatenate(curr, str);
            dfs(tmp, low, high);
        }
    }
    
    public String concatenate(String str, String mid){
        int len = str.length();
        return str.substring(0, len/2) + mid + str.substring(len/2);
    }
    
    public boolean isValid(String str, String low, String high){
        int len = str.length(), len1 = low.length(), len2 = high.length();
        if(len < len1 || len > len2)return false;
        if(len == len1)
            if(str.compareTo(low) < 0)return false;
        if(len == len2)
            if(str.compareTo(high) > 0)return false;
        return true;
    }
}
