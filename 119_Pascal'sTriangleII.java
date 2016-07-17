public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<Integer>();
        
        tmp.add(1);//deal with the first row
        
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i-1; j>=1; j--){// the element before should not be updated
                tmp.set(j, (tmp.get(j-1) + tmp.get(j)));// cannot use add
            }
            tmp.add(1);//deal with the last column
        }
        
        return tmp;
    }
}
