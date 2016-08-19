/* Analysis 
(1) for the first row and the last row, the gap = numRows + numRows - 2;
(2) for the middle parts, the gap between the 1st and 3rd is (gap);
    the gap between 2nd and 3rd is (2i) => the gap between the 1st and 2nd is (gap - 2i); 
    So the gaps for the whole row is gap - 2i, 2i, gap - 2i, 2i, gap - 2i...
*/

public class Solution {
    public String convert(String s, int numRows) {
        if(s==null || s.length() <= 2 || numRows == 1 || numRows >= s.length())return s;
        
        StringBuilder sb = new StringBuilder();
        int round = numRows * 2 - 2, gap = 0;
        
        for(int i = 0; i < numRows; i++){
            for(int j = i; j < s.length() && j >=0; j += gap){
                sb.append(s.charAt(j));
                if(i == 0 || i == numRows - 1){
                    gap = round;
                }
                else{
                    if(j == i)
                        gap = round - 2*i;
                    else
                        gap = round - gap;
                }
                //System.out.println("i = " + i + ", j = " + j + ", gap = " + gap);
            }
        }
        
        return sb.toString();
    }
}
