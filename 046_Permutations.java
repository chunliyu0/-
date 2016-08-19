/* Anlaysis - DP 
Each time add a new number, insert it into different positions and construct a new list
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)return ret;
        
        ret.add(new ArrayList(Arrays.asList(nums[0])));
        for(int i = 1; i < nums.length; i++){//for each length, create the result list
            List<List<Integer>> copy = new ArrayList<List<Integer>>(ret);
            Iterator it = copy.iterator();
            while(it.hasNext()){
                List tmp = (List)it.next();
                for(int j = tmp.size(); j >= 0; j--){
                    List<Integer> list = new ArrayList<>(tmp);
                    list.add(j, nums[i]);
                    ret.add(list);
                }
                ret.remove(tmp);
            }
        }
        return ret;
    }
}
