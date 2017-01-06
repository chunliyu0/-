public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int []> comp = new Comparator<int []>(){
            @Override
            public int compare(int [] p1, int [] p2){
                if(p1[0] == p2[0]){
                    return p1[1] - p2[1];
                }
                else{
                    return p2[0] - p1[0];
                }
            }
        };
        Arrays.sort(people, comp);
        
        List<int[]> list = new ArrayList<>();
        for (int[] pair : people) {
            list.add(pair[1], pair);
        }
        
        int n = list.size();
        return list.toArray(new int[n][]);
    }
}
