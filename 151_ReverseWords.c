#include<string.h>

//note: *s is not immuntable while s[] can be changed
void reverseWords(char *s) {
	int len = 0, begin = 0, end = 0, i;
	
	//get rid of extra spaces and get the actural length
	for (i = 0; s[i]!='\0'; i++) {
		if ((s[i] != ' ') || (s[i] == ' '&& len>0 &&s[i + 1] != ' '&&s[i+1]!='\0')) {
			s[len++] = s[i];
		}		
	}
	s[len] = '\0';

	for (i = 0; i < len / 2; i++) {
		swap(s, i, len-1-i);
	}
	
	for (i = 0;i<=len;i++) {
		if (s[i] == ' '||s[i]=='\0') {
			end = i - 1;
			while (begin<end) {
				swap(s, begin, end);
				begin++;
				end--;
			}
			begin = i + 1;
		}
	}
}

void swap(char s[], int i, int j) {
	char tmp;
	tmp = s[i];
	s[i] = s[j];
	s[j] = tmp;
}
