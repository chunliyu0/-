/* Analysis
(1) n is the number of characters which is part from the file and save them to the buf
(2) limit = Math.min(n, count);
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        
        while(n > 0){
            char [] buf4 = new char[4];
            int count = read4(buf4);
            int limit = Math.min(n, count);
            
            int j = 0;
            while(j < limit)
                buf[i++] = buf4[j++];
                
            if(count < 4) break;
            n = n-4;
        }
    
        return i;
    }
}
