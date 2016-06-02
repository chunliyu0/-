/* Analysis
(1) Save the corresponding sysmbols to the array
(2) consider the exceptinal cases like 900 = CM, 4 = IV
*/

public class Solution {
    public String intToRoman(int num) {
        int    [] vals = {1000, 900, 500, 400, 100, 90, 50,  40, 10,   9,   5,   4,   1};
        String [] syms = {"M", "CM", "D","CD", "C","XC","L","XL","X", "IX","V", "IV","I"};
        String ret = "";
        int count = 0;
        
        for(int i = 0; num>0; i++){
            count = num / vals[i];
            num %= vals[i];
            while(count>0){
                ret += syms[i];
                count--;
            }
        }
        
        return ret;
    }
}
