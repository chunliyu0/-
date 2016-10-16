public class Solution {
    HashMap<String, Integer> ref = new HashMap<>();
    HashMap<Character, String> loc = new HashMap<>();
    
    public String originalDigits(String s) {
        initLoc();
        
        // Collect the string characters
        char[] arr = s.toCharArray();
        char[] map = new char[26];
        for(char ch: arr)
            map[ch-'a']++;
        
        // get the count of each number and save it into an array
        int[] ret = new int[10];
        char[] chs = {'z', 'w', 'u', 'x', 'g', 'o', 'r', 'f', 'v', 'i'};
        for(char key: chs){
            //System.out.println(key);
            while(map[key - 'a'] > 0){
                String str = loc.get(key);
                int idx = ref.get(str);
                ret[idx]++;
                
                char[] tmp = str.toCharArray();
                for(char ch: tmp)
                    map[ch - 'a']--;
            }
        }
        
        // convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ret.length; i++){
            while(ret[i] > 0){
                sb.append(i);
                ret[i]--;
            }
        }
        
        return sb.toString();
    }
    
    public void initLoc(){
        loc.put('z', "zero");
        loc.put('w', "two");
        loc.put('u', "four");
        loc.put('x', "six");
        loc.put('g', "eight");
        loc.put('o', "one");
        loc.put('r', "three");
        loc.put('f', "five");
        loc.put('v', "seven");
        loc.put('i', "nine");
        
        ref.put("zero", 0);
        ref.put("one", 1);
        ref.put("two", 2);
        ref.put("three", 3);
        ref.put("four", 4);
        ref.put("five", 5);
        ref.put("six", 6);
        ref.put("seven", 7);
        ref.put("eight", 8);
        ref.put("nine", 9);
    }
}
