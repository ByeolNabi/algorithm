#include <iostream>
using namespace std;

//_02292번 : 벌집
	//껍질의 개수 공식 찾기
int main() {
		int shell = 1;
		int x = 6;
		double num;
		cin >> num;
		while (true) {
			int result = (1 + 3 * (shell - 1) + 3 * (shell - 1) * (shell - 1));
			if (num / result > 1) {
				shell++;
			}
			else {
				cout << shell << "\n";
				break;
			}
		}
	return 0;
}
/*
* 1
* 7		6개
* 19	12개
* 37	18개
* 61	24개
* 
* 증가값이 6씩 증가
* 
* 1+3n+3n^2		//시그마 정리하기
*/