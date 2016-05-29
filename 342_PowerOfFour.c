/* Analysis
((num & (num - 1)) == 0) is to check if num is power of two
 (num & 0x55555555) !=0 is to check if the 1 is on the odd bit
*/

bool isPowerOfFour(int num) {
    return (num & (num - 1)) == 0 && (num & 0x55555555)  !=0;
}
