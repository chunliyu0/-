/*corner cases:
(1) return 0 for null string;
(2) white spaces in the beginning;
(3) sign;
(4) Throw characters after the integral part, "1 2 3 4" returns 1;
(5) Overflow;
*/

int myAtoi(char* str) {
    if(str==NULL||str=="")return 0;//(1) return 0 for null string;
    
    int ret = 0;
    
    //(2) throw the white spaces in the beginning
    int i=0;
    while(str[i]==' ')
        i++;
        
    //(3) deal with the sign
    int sign = 1;
    if(str[i]=='-'){
        sign = -1;
        i++;
    }
    else if(str[i]=='+'){
        sign = 1;
        i++;
    }
        
    if(str[i]>='0' && str[i]<='9'){
        ret = str[i]-48;
        i++;
        while(str[i]>='0'&&str[i]<='9'){// (4)The characters in the tail are not considered
            
            //(5) deal with overflow
            if((INT_MAX - (str[i]-48))/10 < ret)
                if(sign==1)
                    return INT_MAX;
                else
                    return INT_MIN;
                    
            ret = 10*ret + (str[i]-48);
            i++;
        }
    }
    
    return sign* ret;
}
