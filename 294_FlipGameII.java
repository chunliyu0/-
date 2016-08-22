/* Analysis - Backtracking -> DFS*/

public class Solution {
    public boolean canWin(String s) {
        if(s==null || !s.contains("++"))return false;
        if(s.contains("++") && s.length() <= 4)return true;
        
        char [] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == '+' && arr[i+1] == '+')
                if(!canWin(s.substring(0, i) + "-" + s.substring(i+2)))
                    return true;
        }
        return false;
    }
}

/*
public boolean canWin(String s) {
    if(s==null||s.length()==0){
        return false;
    }
 
   return canWinHelper(s.toCharArray()); 
}
 
public boolean canWinHelper(char[] arr){
    for(int i=0; i<arr.length-1;i++){
        if(arr[i]=='+'&&arr[i+1]=='+'){
            arr[i]='-';
            arr[i+1]='-';
 
            boolean win = canWinHelper(arr);
 
            arr[i]='+';
            arr[i+1]='+';
 
            //if there is a flip which makes the other player lose, the first play wins
            if(!win){
                return true;
            }
        }
    }
 
    return false;
}
*/
