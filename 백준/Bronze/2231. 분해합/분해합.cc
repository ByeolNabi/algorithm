#include <iostream>

using namespace std;

int main() {
	int Nature = 0, target, Nature_c;
	int total=0;
	cin >> target;

	while (Nature != target) {
		Nature_c = Nature;
		for (int div : {1000000, 100000, 10000, 1000, 100, 10, 1}) {
			total += Nature_c / div;
			Nature_c = Nature_c-(Nature_c / div)*div;
		}
		total += Nature;
		if (target == total) {
			cout << Nature;
			return 0;
		}
		total = 0;
		++Nature;
	}

	cout << 0;

	return 0;
}