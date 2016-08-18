/* Analysis 
Start from the second last row
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(triangle==null || n == 0)return 0;
        for(int i = n-2; i >= 0; i--){// start from the second last row
            for(int j = 0; j <= i; j++){
                List<Integer> curr = triangle.get(i);//get the current row
                List<Integer> post = triangle.get(i+1);
                int min = Math.min(post.get(j), post.get(j+1));
                curr.set(j, curr.get(j) + min);
            }
        }
        return triangle.get(0).get(0);
    }
}
