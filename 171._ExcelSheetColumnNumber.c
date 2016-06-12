/* Analysis
(1) Convert the each charactor to int: ch - 64;
(2) Similar to decimal format, it's 26 format;
*/

int titleToNumber(char* s) {
    if(s==NULL)return 0;
    int len = strlen(s), ret = 0;
    char ch;
    
    for(int i = 0; i<len; i++){
        ch = s[i];
        ret = ret*26 + (ch-64);
    }
    
    return ret;
}
