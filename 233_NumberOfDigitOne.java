//http://blog.csdn.net/xudli/article/details/46798619

/* Analysis
(1) the ones in decimal numbers
(2) for every 10 numbers, there is 1 1s at units;
    for every 100 numbers, there are 10 1s at tens;
    for every 1000 numbers, there are 100 1s at hundreds;
(3) 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况: 
    case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
    case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次. 
    case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次. 
    以上三种情况可以用 一个公式概括:(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
*/

public class Solution {
    public int countDigitOne(int n) {
        int ret = 0;  
        for (long m = 1; m <= n; m *= 10) { //start from units, then tens..hundres..thousands
            long a = n/m, b = n%m;  
            ret += (a + 8) / 10 * m;  
            if(a % 10 == 1) ret += b + 1; //get the digit on the current bit 
        }  
        return ret;
        
    }
}
