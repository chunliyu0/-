/* Analysis
(1) Reverse the whole string first -> Reverse each string
(2) For the last string, the punctuation marks should be considered.
*/

void swap(char *a, char *b){
    char tmp = *a;
    *a = *b;
    *b = tmp;
}

void reverseWord(char s[], int i, int j){
    char tmp;
    while(i<j){
        swap(&s[i], &s[j]);
        i++;
        j--;
    }
}

void reverseWords(char *s) {
    int i=0, j=0;
    
    //reverse the whole string
    reverseWord(s, 0, strlen(s) - 1);
    
    //reverse each word
    for(i=0, j=0; s[j]!='\0'; j++){
        if(s[j]==' '){
            reverseWord(s, i, j-1);
            i = j+1;
        }
    }
    
    //reverse the last string with punctuation marks
    if(s[j-1]=='!'||s[j-1]=='?'||s[j-1]=='.')
        reverseWord(s, i, j-2);
    else
        reverseWord(s, i, j-1);
}
