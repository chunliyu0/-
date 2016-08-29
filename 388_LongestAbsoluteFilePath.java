/* Analysis - HashMap */

public class Solution {
    public int lengthLongestPath(String input) {
        String [] lines = input.split("\n");//analyze line by line, each line is either a directory or a file
        Map<Integer, Integer> map = new HashMap<>();//record the length of the newest folder with ntab as the key
        int max = 0;
        
        System.out.println(input);
        for(String line: lines){
            String name = line.replace("\t", "");
            int ntab = line.length() - name.length();
            int pre = (ntab == 0 ? 0: map.get(ntab - 1));//the root directory doesn't have the previous folder
            if(name.contains(".")){ //it's a file
                max = Math.max(max, pre + name.length());
            }
            else{//it's a folder
                map.put(ntab, pre + name.length() + 1);//each time add '/' in the end of a folder;
            }
        }
        return max;
    }
}
