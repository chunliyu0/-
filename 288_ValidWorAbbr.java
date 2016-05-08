/* (1) if a word has unique abbr in the dictionary, either its abbr does not exist in the map or the map contains this abbr associated with the same word. 
   (2) Since the dictionary may contains diff words with the same abbr, when we add the repeated abbr, the entry added before may be overwritten, thus, we may set the associated word as "" when the abbr is not unique.
*/

public class ValidWordAbbr {
    HashMap<String, String> map;//the abbr is the key while the str is the value
	
    public ValidWordAbbr(String[] dictionary) {
       map = new HashMap<String,String>();
       for(String str: dictionary){
           String abbr = getAbbreviation(str);
           //if this abbr is brand new, add it to the list
           if(!map.containsKey(abbr))
               map.put(abbr,str);
           //if there is already this abbr existing associated with other word, using "" to represent the repeation.
           else if(!map.get(abbr).equals(str))
               map.put(abbr,"");
       }
   }

   public boolean isUnique(String word) {
       //cornel case: the abbreviatio for the word with length <=2 is unique
       if(word.length()<=2)return true;
       
       //for longer words, its abbreviation cannot be "";
       String abbr = getAbbreviation(word);
       return !map.containsKey(abbr)||map.get(abbr).equals(word);
   }
   
   public String getAbbreviation(String word){
       int len = word.length();
       if(len <=2)
          return word;
       return  word.charAt(0) + Integer.toString(len-2) + word.charAt(len-1);

   }
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
