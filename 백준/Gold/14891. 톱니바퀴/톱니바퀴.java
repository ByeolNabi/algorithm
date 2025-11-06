import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 톱니바퀴
public class Main {
	static int[][] wheels = new int[4][8];
	static boolean[] visited;
	static int[][] cmd;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				wheels[i][j] = s.charAt(j) - '0';
			}
		}

		int k = Integer.parseInt(br.readLine());
		cmd = new int[k][2];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			cmd[i][0] = Integer.parseInt(st.nextToken())-1;
			cmd[i][1] = Integer.parseInt(st.nextToken());
		}

//		// 입력 잘 받았나?
//		for (int i = 1; i < 5; i++) {
//			System.out.println(Arrays.toString(wheels[i]));
//		}

		// 논리

		/*
		 * 일단 돌아가게 해야겠지?
		 * 1,2 : (2,6) | 2,3 : (2,6) | 3,4 : (2,6) 
		 * 
		 * 왼쪽 탐색, 오른쪽 탐색
		 * 3을 돌리면 [오른쪽] 3-2와 4-6을 비교 [왼쪽] 3-6과 2-2 비교
		 *  -> 만약 돌아간다면 한 칸 옆도 비교하기, 안 돌아간다면 좌우 전이 탐색 종료
		 */

		for (int c = 0; c < k; c++) {
			visited = new boolean[4];
			spin(cmd[c][0], cmd[c][1]);
		}

		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += (wheels[i][0] << i);
		}

//		for (int i = 1; i < 5; i++) {
//			System.out.println(Arrays.toString(wheels[i]));
//		}

		System.out.println(result);
	}

	public static void spin(int wNum, int arrow) {
		visited[wNum] = true;
		// wNum을 arrow 방향으로 돌린다.

		// [오른쪽]wNum + 1을 돌릴 수 있으면 돌린다. 2 <-> 6
		if (wNum + 1 < 4) {
			// wNum이랑 극이 다르면 탐
			if (wheels[wNum][2] != wheels[wNum + 1][6] && !visited[wNum + 1]) {
				spin(wNum + 1, -arrow);
			}
		}
		// [왼]wNum-1을 돌릴 수 있으면 돌린다.
		if (0 <= wNum - 1) {
			if (wheels[wNum][6] != wheels[wNum - 1][2] && !visited[wNum - 1]) {
				spin(wNum - 1, -arrow);
			}
		}

		// 사실 돌리는건 여기서 하지롱~
		push(wNum, arrow);
	}

	public static void push(int wNum, int arrow) {
		int tmp = 0;
		if (arrow == 1) { // 시계
			tmp = wheels[wNum][7];
			for (int i = 7; i > 0; i--) {
				wheels[wNum][i] = wheels[wNum][i - 1];
			}
			wheels[wNum][0] = tmp;
		} else if (arrow == -1) { // 반시계
			tmp = wheels[wNum][0];
			for (int i = 0; i < 7; i++) {
				wheels[wNum][i] = wheels[wNum][i + 1];
			}
			wheels[wNum][7] = tmp;
		}
	}
}

/*
 * 10101111 // N극은 0, S극은 1 
 * 01111101 // 12시방향부터 시계방향 순서대로 주어진다
 * 11001110 
 * 00000010 
 * 2 
 * 3 -1 // (톱니바퀴 번호, 방향) // 시계방향 1 , 반시계 -1 
 * 1 1
 */

/*
 * 1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점 
 * 2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점 
 * 3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점 
 * 4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
 */

// 1시간