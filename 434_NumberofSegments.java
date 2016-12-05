public class Solution {
    public int countSegments(String s) {
        int n = s.length();
        if(n == 0)return 0;
        int count = 0;
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            char pre = s.charAt(i - 1);
            if(ch == ' ' && pre != ' ')
                count++;
        }
        return s.charAt(n-1) == ' '? count: count + 1;
    }
}
