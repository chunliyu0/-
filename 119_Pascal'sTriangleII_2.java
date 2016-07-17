/* Analysis
Current Element = prevent element * (rows + 1 - col) / col
*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i=1; i<=rowIndex; i++) {
            list.add((int) ((long)list.get(i-1)*(rowIndex+1-i)/i));
        }
        return list;
    }
}
