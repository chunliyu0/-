/* Analysis
(1) find the original string as the key
(2) put all the anagrams under the same key
*/

public class Solution {
    public String getOriginal(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0)return null;
        
        List<List<String>> ret = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str: strs){
            String orig = getOriginal(str);
            List<String> tmp = new ArrayList<String>();
            if(map.containsKey(orig)){
                tmp = map.get(orig);
            }
            tmp.add(str);
            map.put(orig,tmp);
        }
        
        for(List list: map.values()){
            ret.add(list);
        }
        
        return ret;
        
    }
}
