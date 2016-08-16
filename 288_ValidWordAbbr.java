/* Analysis - HashMap */

public class ValidWordAbbr {
     Map<String, List<String>> map;
     
     //constructor
     public ValidWordAbbr(String[] dictionary) {
     	map = new HashMap<>();//abbr is the key while string is the value;
        for(String str: dictionary){
            List<String> tmp = new ArrayList<String>();
            String abbr = getAbbr(str);
            
            if(map.containsKey(abbr))
                tmp = map.get(abbr);
            tmp.add(str);
            map.put(abbr, tmp);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        if(map.containsKey(abbr))
            for(String str : map.get(abbr))
                if(!str.equals(word))
                    return false;
        return true;
    }
    
    public String getAbbr(String str){
       int len = str.length();
       return (len <= 2 ? str: str.charAt(0) + Integer.toString(len-2) + str.charAt(len-1));
   }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
