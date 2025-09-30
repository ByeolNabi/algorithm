#include <iostream>
using namespace std;

//_04153번 : 직각삼각형
int main() {
	while (true) {
		int a, b, c;
		cin >> a >> b >> c;
		if (a == 0 && b == 0 && c == 0) return 0;
		if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
			printf("right\n");
		}
		else { printf("wrong\n"); }
	}
	return 0;
}