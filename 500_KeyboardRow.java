/* Given a List of words, return the words that can be typed using letters of alphabet 
   on only one row's of American keyboard like the image below.
   Example 1: Input: ["Hello", "Alaska", "Dad", "Peace"]    Output: ["Alaska", "Dad"]
   Note: You may use one character in the keyboard more than once.
         You may assume the input string will only contain letters of alphabet.
 */
 
 class Solution {
    public String[] findWords(String[] words) {
        String ref = "QWERTYUIOPASDFGHJKL-ZXCVBNM";
        List<String> ret = new ArrayList<String>();
        for(int i = 0; i < words.length; i++){
            boolean isRow = true;
            char[] arr = words[i].toUpperCase().toCharArray();
            int sizeArr = arr.length;
            if(sizeArr == 0)
                continue;
            int index = ref.indexOf(arr[0])/10;
            for(int j = 1; j<sizeArr; j++){
                if(ref.indexOf(arr[j])/10 != index){
                    isRow = false;
                    break;
                }
            }
            if(isRow)
                ret.add(words[i]);
        }
        return ret.toArray(new String[ret.size()]);
    }
}
