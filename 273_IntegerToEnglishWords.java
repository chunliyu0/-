/* Analysis
Billion -> Million -> thousand -> hundred 
*/

public class Solution {
    public String thousand(int num){
        String ret = "", spc = "";
        String [] refs = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen", "Twenty", "Thirty", "Forty","Fifty","Sixty","Seventy", "Eighty", "Ninety"};
        
        //deal with the tens and units digit together
        int idx = num % 100;
        if(idx > 20){
            idx = 18 + idx/10;
            spc = (num%10==0 ? "": " ");
        }
        ret = (spc==""?refs[idx]: refs[idx] + spc + refs[num%10]);
        
        //deal with hundreds digit
        if(num/100 == 0) return ret;
        if(num%100 == 0) return refs[num/100] + " Hundred";
        return refs[num/100] + " Hundred " + ret;
    }
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";//pay attention to this special case
        
        String ret = "";
        String [] refs = {"", " Thousand", " Million", " Billion"};
        int i = 0;
        while(num / 1000 != 0 || num % 1000 != 0){
            if(thousand(num % 1000)!=""){
                if(ret=="")
                    ret =  thousand(num % 1000) + refs[i];
                else
                    ret =  thousand(num % 1000) + refs[i] + " " + ret;
            }
            num /= 1000;
            i++;
        }
        return ret;
    }
}
