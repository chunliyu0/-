/* Analysis
(1) transfer int array to string array
(2) sort the string array based on the combination result
(3) check if the array contains only "0"s
(4) concatenate the array
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums==null)return "";
        String [] strs = new String[nums.length];
        String ret = "";
        
        //transfer int array to string array
        for(int i = 0; i<nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        
        //sort the string array based on the combination result.
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String str1, String str2) {
	            return (str1 + str2).compareTo(str2 + str1);
            }
        });
        
        //check if the array contains only "0"s;
        if(strs[strs.length-1].charAt(0)=='0')return "0";
        
        //concatenate the strings
        for(int i = strs.length-1; i>=0;i--){
            ret += strs[i];
        }
        return ret;
    }
}
