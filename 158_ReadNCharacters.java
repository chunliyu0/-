/* Analysis
(1) buf is the return string, not the input file
(2) case 1: we may just want 1 character of a long file
    case 2: we want n characters while the file only have 1 character
    case 3: we may read many times, read(1) and read(2) for "abcde" while read(1) get the characters which belong to read(2);
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
      
    char[] buf4 = new char[4];
    int j = 0, count = 0;
    
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n){
            if(j < count){// the case when last reading read more characters
                buf[i++] = buf4[j++];//read one chracter one time
            }
            else if(j == count){// the case we need to restart reading
                j = 0;
                count = read4(buf4);
                if(count == 0)break;//stop when there are no more characters in the file
            }
        }
        return i;
    }
}
