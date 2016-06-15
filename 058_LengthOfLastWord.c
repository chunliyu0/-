/* Analysis
(1) scan from the tailing and ignore the spaces from the end
(1) do a second scan from the valid place until a space shows up.
*/

int lengthOfLastWord(char* s) {
    if(s==NULL||strlen(s)==0)return 0;
    
    //printf("len = %d\n", strlen(s));
    int i = strlen(s)-1, ret = 0;
    while(s[i]==' '&&i>=0){
        i --;
    }
    if(i==-1) return 0;
    while(s[i]!=' '&&i>=0){
        ret ++;
        i --;
    }
    
    return ret;
}
