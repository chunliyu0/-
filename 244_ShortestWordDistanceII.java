public class WordDistance {
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    
    public WordDistance(String[] words) {
        for(int i = 0; i<words.length; i++){
            List<Integer> list = new ArrayList<Integer>();
            if(map.containsKey(words[i])){
                list = map.get(words[i]);
            }
            list.add(i);
            map.put(words[i], list);
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        
        for(int val1 : list1){
            for(int val2 : list2){
                min = Math.min(min, Math.abs(val1 - val2));
                if(val2 > val1){
                    break;
                }
            }
        }
        
        return min;
    }
}
// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
