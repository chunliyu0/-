/* Analysis - Bit manipulation */

public class Solution {
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0)return true;
        
        //preprocessing - get the least significant 8 bits
        for(int val: data)
            val = (val & 0xFF);
        
        for(int i = 0; i < data.length; i++){
            if(data[i] < 0b10000000)continue;
            
            int count = 0;
            while(((data[i] & 0xFF) >> 7) == 1){
                count ++;
                data[i] = ( data[i] << 1);
            }
            if(count == 1 || count == 8 || count > data.length - i)return false;
            int j = i+1;
            while(j < i + count){
                if(((data[j] & 0xC0) >> 6) != 0b10)
                    return false;
                j++;
            }
            
            i = j - 1;
        }
        return true;
    }
}
