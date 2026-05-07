#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int flag = true;
    for(int i = 0; i < s.length(); i++){
        if(s[i] == ' '){
            flag = true;
        }else{
            if(flag){
                s[i] = toupper(s[i]);
                 flag=false;
            }else{
                s[i] = tolower(s[i]);
               
            }
        }
    }   
    
    return s;
}