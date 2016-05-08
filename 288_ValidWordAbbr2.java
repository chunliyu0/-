public class ValidWordAbbr {
     Map<String, String> map = new HashMap<String, String>();
	
     public ValidWordAbbr(String[] dictionary) {
        for(String str: dictionary){
            map.put(str, getAbbreviation(str));
        }
    }

    public boolean isUnique(String word) {
        String val = getAbbreviation(word);
            
        if(map.containsKey(word))
        	map.remove(word);
        
    	return !map.containsValue(val))
    }
    
    public String getAbbreviation(String word){
        int len = word.length();
        if(len<=2)
            return word;
        return  word.charAt(0) + Integer.toString(len-2) + word.charAt(len-1);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
