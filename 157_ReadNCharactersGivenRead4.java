/* Analysis
(1) n is the number of characters which is part from the file and save them to the buf
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
        int count = 0;
        
        while(n > 0){
            char [] tmp = new char[4];
            int len = read4(tmp);
            if(len == 0)break; // reach the end of the file
            int limit = Math.min(n, len);
            for(int i = 0; i < limit; i++){//copy the new readed array to the result array
                buf[count++] = tmp[i];
            }
            n -= 4;
        }
    
        return count;
    }
}
