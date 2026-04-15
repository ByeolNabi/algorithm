#include <iostream>
#define MAX 8
#define VISITED 8
using namespace std;

int N, M;
int arr[MAX + 2][MAX + 2], visited[MAX + 2][MAX + 2];

// 0 좌표 저장 클래스
class zeros {
public:
	int co[64][2] = { 0 };
	int top = 0;
	void push(int row, int column) {
		co[top][0] = row;
		co[top][1] = column;
		++top;
	}
};

void copyV(int endX, int endY) {
	for (int i = 0; i < endX + 2; ++i) {
		for (int j = 0; j < endY + 2; ++j) {
			visited[i][j] = arr[i][j];
		}
	}
}

void init(int endX, int endY) {
	for (int i = 0; i < MAX + 2; ++i) {
		arr[i][0] = 1;
		arr[0][i] = 1;
		arr[endX + 1][i] = 1;
		arr[i][endY + 1] = 1;
	}
	copyV(endX, endY);
}

int check(int row, int col) {
	int c = 0;
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < 3; ++j) {
			if (visited[row - 1 + i][col - 1 + j] == 1) {
				++c;
			}
		}
	}
	if (c > 1) {
		return true;
	}
	else {
		return false;
	}
}

void DFS(int row, int column) {
	visited[row][column] = VISITED;
	if (visited[row][column + 1] == 0) {
		DFS(row, column + 1);
	} // 오른
	if (visited[row + 1][column] == 0) {
		DFS(row + 1, column);
	} // 아래
	if (visited[row][column - 1] == 0) {
		DFS(row, column - 1);
	} // 왼
	if (visited[row - 1][column] == 0) {
		DFS(row - 1, column);
	} // 위
}

int main() {
	int row, column;
	int num, max = -1;
	zeros coor;

	// 입력받기
	cin >> row >> column;
	for (int i = 0; i < row; ++i) {
		for (int j = 0; j < column; ++j) {
			cin >> num;
			arr[i + 1][j + 1] = num;
			if (num == 0) { // 0좌표 저장해두기
				coor.push(i + 1, j + 1);
			}
		}
	}

	// 테두리 만들기, visited에 옮겨담기
	init(row, column);

	// 벽 세울 공간 찾기
	for (int i = 0; i < coor.top; ++i) {
		for (int j = i + 1; j < coor.top; ++j) {
			for (int k = j + 1; k < coor.top; ++k) {
				visited[coor.co[i][0]][coor.co[i][1]] = 1;
				visited[coor.co[j][0]][coor.co[j][1]] = 1;
				visited[coor.co[k][0]][coor.co[k][1]] = 1;
				if (check(coor.co[i][0], coor.co[i][1]) &&
					check(coor.co[j][0], coor.co[j][1]) &&
					check(coor.co[k][0], coor.co[k][1])) {

					// DFS탐색
					for (int i = 0; i < row; ++i) {
						for (int j = 0; j < column; ++j) {
							if (arr[i + 1][j + 1] == 2) {
								DFS(i + 1, j + 1);
							}
						}
					}

					// 안전공간 카운트
					int count = 0;
					for (int i = 0; i < row; ++i) {
						for (int j = 0; j < column; ++j) {
							if (visited[i + 1][j + 1] == 0) {
								++count;
							}
						}
					}

					if (max < count) {
						max = count;
					}
					// visited 초기화
					copyV(row, column);
				}
				else {
					visited[coor.co[i][0]][coor.co[i][1]] = 0;
					visited[coor.co[j][0]][coor.co[j][1]] = 0;
					visited[coor.co[k][0]][coor.co[k][1]] = 0;
				}
			}
		}
	}
	std::cout << max;
	/*
	for (int i = 0; i < coor.top; ++i) {
		cout << endl << '[' << coor.co[i][0] << ':' << coor.co[i][1] << ']';
	}
	*/
	return 0;
}