/* Analysis - HashMap
(1) get the corresponding derivation
(2) add the string to the derivation collection
*/

public class Solution {
    public String getOriginal(String str){
        char [] arr = str.toCharArray();
        int shift = 'z' - arr[0];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (char)((arr[i]+ shift > 'z')? arr[i]+ shift - 26: arr[i] + shift );
        }
        return new String(arr);
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        if(strings==null) return null;
        
        List<List<String>> ret = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        
        for(String str: strings){
            String orig = getOriginal(str);
            List<String> tmp= new ArrayList<String>();
            if(map.containsKey(orig)){
                tmp = map.get(orig);
            }
            tmp.add(str);
            map.put(orig, tmp);
        }
        
        for(List<String> list: map.values()){
            ret.add(list);
        }
        return ret;
    }
}
