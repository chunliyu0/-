/* Analysis 
(1) substitute " no,#,# " with "#" and reconstruct the string
(2) Be careful that we should not use replace to reconstruct the string (9,#,#,59, #,#)
*/

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length()==0)return true;
        
        while(preorder.contains(",#,#")){
            if(preorder.charAt(0)=='#') return false;
            
            int fromidx = preorder.indexOf(",#,#") - 1;
            int idx = preorder.lastIndexOf(",", fromidx) + 1;
            
            preorder = preorder.substring(0, idx) + "#" + preorder.substring(fromidx + 5);
        }
        if(preorder.equals("#"))return true; 
        return false;
    }
}
