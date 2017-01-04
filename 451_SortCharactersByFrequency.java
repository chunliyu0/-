public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch, (map.containsKey(ch)? map.get(ch)+1: 1));
        }
       
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
        Comparator comp = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };
        list.sort(comp);
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> pair : list) {
            char ch = pair.getKey();
            int num = pair.getValue();
            for (int i = 0; i < num; i++) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
