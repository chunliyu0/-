/* Analysis - Math
(1) A bulb ends up on iff it experienced odd toggles. So bulb i ends up on if and only if it has an odd number of divisors.
(2) Divisors come in pairs, like i=12 has divisors 1 and 12, 2 and 6, and 3 and 4. 
    Except when i is a square, like 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. 
    So bulb i ends up on if and only if i is a square.
(3) Just count the square numbers. That is, the number of the square roots.
    Let R = int(sqrt(n)). That's the root of the largest square in the range [1,n]. 
    And 1 is the smallest root. So you have the roots from 1 to R, that's R roots. Which correspond to the R squares.
*/

public class Solution {
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n); 
    }
}
