public class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(String str: words){
                if(str.length() <= i)break;
                sb.append(str.charAt(i));
            }
            if(!sb.toString().equals(words.get(i)))
                return false;
        }
        return true;
    }
}
