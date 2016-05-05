//create another string and fill it by the orignial string from the end to the start
char* reverseString(char* s) {
    char * ret;
    int len = strlen(s);
    for(int i = len-1;i>=0;i--){
        ret[len-1-i]=s[i];
    }
    ret[len] = '\0';
    return ret;
}
