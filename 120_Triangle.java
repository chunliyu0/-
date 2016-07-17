/* Analysis - ArrayList
if the list is added to another list, then the sub list cannot be updated again, 
otherwise the one in the parent list will be changed.
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> pre = new ArrayList<Integer>();
        
        if(numRows==0)return ret;
        pre.add(1);//deal with the first row
        ret.add(pre);
        
        for(int i = 2; i<=numRows; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);//deal with the first column
            for(int j = 1; j<i-1; j++){
                tmp.add(pre.get(j-1) + pre.get(j));
            }
            tmp.add(1);//deal with the last column
            ret.add(tmp);
            pre = tmp;
        }
        
        return ret;
    }
}
