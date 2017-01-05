public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()+"/"+str);
        } 
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> list = new ArrayList<>();
        int n = s.length(), i = 0;
        
        while(i < n){
            int idx = s.indexOf('/', i);
            int size = Integer.parseInt(s.substring(i, idx));
            String str = s.substring(idx+1, idx + 1 + size);
            list.add(str);
            i = idx + 1 + size;
        }
        
        return list;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
