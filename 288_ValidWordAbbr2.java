public class ValidWordAbbr {
    Map<String, String> map = new HashMap<String, String>();
	
     public ValidWordAbbr(String[] dictionary) {
        for(String str: dictionary){
            map.put(str, getAbbreviation(str));
        }
    }

    public boolean isUnique(String word) {
        String val = getAbbreviation(word);
            
        if(map.containsKey(word)){
        	map.remove(word);
        }
        
    	if(map.containsValue(val))
    		return false;
    	return true;
    }
    
    public String getAbbreviation(String word){
        int len = word.length();
        String val = "";
        if(len<=2)
            val = word;
        else
            val = "" + word.charAt(0) + (len-2) + word.charAt(len-1);
        return val;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
