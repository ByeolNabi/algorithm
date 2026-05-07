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
                flag = false;
            }else{
                s[i] = tolower(s[i]);
            }
        }
    }
    return s;
}

// 일단 전체를 돌아보면서 flag가 활성화되어있으면서 영어가 나왔으면 높이기
// 