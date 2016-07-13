/* Analysis - Sequential search*/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<String>();
        char [] arr = s.toCharArray();
        int pre = -1;
        
        if(s==null || s.length()<2)return ret;
        for(int i = 1; i<arr.length; i++){
            if(arr[i]=='+' && arr[i-1]=='+'){
                ret.add(s.substring(0, i-1) + "--" + s.substring(i+1,arr.length));
            }
        }
        
        return ret;
    }
}
