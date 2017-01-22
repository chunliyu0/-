public class Solution {
    public int[] constructRectangle(int area) {
        int width = (int)Math.floor(Math.sqrt(area));
        
        while(area%width != 0){
            width --;
        }
        
        int[] ret = new int[2];
        ret[0] = area / width;
        ret[1] = width;
        return ret;
    }
}
