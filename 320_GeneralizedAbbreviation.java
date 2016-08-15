/* Analysis - DFS
(1) draw a tree from top down, the head node should be "", all the leaves are the final results
(1) for each path we choose to abbreviate the current character or not.
*/

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> ret = new ArrayList<>();
        DFS(word.toCharArray(), ret, "", 0, 0);
        return ret;
    }
    
    public void DFS(char[] arr, List<String> list, String str, int i, int num) {
        if(i == arr.length) {
            if(num != 0) str += num;
            list.add(str);
            return;
        } 
        
        DFS(arr, list, str, i + 1, num + 1);// abbr arr[i] to 1

        if(num != 0) str += num;// not abbr arr[i]
        DFS(arr, list, str + arr[i], i + 1, 0);        
    }
}
