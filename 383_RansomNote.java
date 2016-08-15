/* Analysis - HashMap*/


public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null)return true;
        if(magazine == null)return false;
        
        int rlen = ransomNote.length(), mlen = magazine.length();
        if(rlen > mlen)return false;
        if(rlen == mlen){
            return ransomNote.equals(magazine);
        }
        
        int [] ref = new int[26];
        for(int i = 0; i<mlen; i++){
            char ch = magazine.charAt(i);
            ref[ch-'a']++;
        }
        
        for(int i = 0; i<rlen; i++){
            char ch = ransomNote.charAt(i);
            ref[ch-'a']--;
            if(ref[ch-'a'] < 0)return false;
        }
        
        return true;
    }
}
