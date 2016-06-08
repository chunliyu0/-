/* Analysis
find the first matched character, then compare all the needle string.
*/

int strStr(char* haystack, char* needle) {
    if(needle==NULL||haystack==NULL||strlen(haystack)<strlen(needle))
        return -1;
    if(strcmp(needle,"")==0)
        return 0;
        
    int i, j=1;
    for(i=0;i<=strlen(haystack)-strlen(needle);i++){
        if(haystack[i]==needle[0]){
            for(j = 1; j<strlen(needle); j++){
                if(haystack[i+j]!=needle[j])
                    break;
            }
            if(j==strlen(needle)){
                return i;
            }
                
        }
    }
    return -1;
}
