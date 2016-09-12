/* Analysis - DFS 
(1) for each sign, get all the combinations of the left substring and all the combinations of the right substring
(2) if the ret size is 0, it means no signs found, add the num into the ret list
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new ArrayList<Integer>();
        dfs(ret, input);
        return ret;
    }
    
    public void dfs(List<Integer> ret, String str) {
        if(str == null || str.length() == 0)return;
        
        char [] arr = str.toCharArray();
        for(int i = 0; i<arr.length; i++){
            if(arr[i] >= '0' && arr[i] <= '9')continue;
           
            List<Integer> left = new ArrayList<Integer>();
            List<Integer> right = new ArrayList<Integer>();
            dfs(left, str.substring(0, i));
            dfs(right, str.substring(i+1));
            
            for(int a: left){
                for(int b: right){
                    switch(arr[i]){
                        case '+': ret.add(a + b);break;
                        case '-': ret.add(a - b);break;
                        case '*': ret.add(a * b);break;
                    }
                }
            }
        }
        
        if(ret.isEmpty()){
            ret.add(Integer.parseInt(str));
        }
    }
}
