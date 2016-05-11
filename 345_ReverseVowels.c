/* Analysis
(1) Use two points, swap the corresponding characters when two vowels with one from one is from the beginning, 
the other one is from the end.
(2) We are trying to find the first vowel, but there may be cases when there is no vowel at all.
(3) the upper case should also be considered.
*/

bool isVowel(char ch){
    ch = toupper(ch);
    return ch == 'A'||ch == 'E'||ch == 'I'||ch == 'O'||ch == 'U';
}

void swap(char *ch1, char *ch2){
    char tmp = *ch1;
    *ch1 = *ch2;
    *ch2 = tmp;
}

char* reverseVowels(char* s) {
    if(s==NULL||strlen(s)<2)return s;
    int i = 0, j = strlen(s)-1;
    while(i<j){
        //the string may not have vowels in which case the loop will go forever.
        while(!isVowel(s[i])&&i<j){
            i++;
        }
        while(!isVowel(s[j])&&i<j){
            j--;
        }
        if(i>=j)break;
        swap(&s[i++], &s[j--]);
    }
    return s;
}
