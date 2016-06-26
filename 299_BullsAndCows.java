/* Analysis - hashmap
(1) figure out the bull and put the secret only about cows to the hashmp
(2) fingue out the cows
*/

public class Solution {
    public String getHint(String secret, String guess) {
        int arr[]= new int[10];
        int cnt1 = 0, cnt2 = 0;
        String ret = "";
    
        for(int i = 0; i<secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i))
                cnt1++;
            else
                arr[secret.charAt(i)-48]++;
        }
    
        for(int i = 0; i<secret.length(); i++){
            if(secret.charAt(i) != guess.charAt(i) && arr[guess.charAt(i)-48]!=0){
                cnt2++;
                arr[guess.charAt(i)-48]--;
            }
        }
        ret += cnt1 + "" + 'A' + ""+ cnt2 + "" +'B';
        return ret;
    }
}
