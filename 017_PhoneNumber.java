/* Analysis
Combination (0, n) = combination(0) + combination(1,n);
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0)
            return new ArrayList<String>();
        if(digits.contains("1")||digits.contains("0"))
            return new ArrayList<String>();
            
        HashMap<Character,String> map = new HashMap<Character, String>();
        List<String> list = new ArrayList<String>();
        
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        if(digits.length()==1){
            for(int i = 0; i<map.get(digits.charAt(0)).length(); i++){
                list.add(""+ map.get(digits.charAt(0)).charAt(i));
            }
            return list;
        }
        else
            for(String str: letterCombinations(digits.substring(1))){
                for(int i = 0; i<map.get(digits.charAt(0)).length(); i++){
                    list.add(""+ map.get(digits.charAt(0)).charAt(i) + str);
                }
            }
        return list;
    }
}
