import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int[][] map;
	static int[][][] dp;

	public static void main(String args[]) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3]; // {-, \, l}
		for (int row = 1; row <= N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 1; col <= N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// 첫줄 업데이트
		dp[1][2][0] = 1;
		for (int i = 3; i < N; i++) {
			if (map[1][i] == 0) {
				dp[1][i][0] = dp[1][i-1][0];
			}
		}

		for (int row = 2; row <= N; row++) {
			for (int col = 1; col <= N; col++) {
				if (map[row][col] == 0) {
					dp[row][col][0] = dp[row][col - 1][0] + dp[row][col - 1][1];
					if (map[row - 1][col] == 0 && map[row][col] == 0 && map[row][col - 1] == 0) {
						dp[row][col][1] = dp[row - 1][col - 1][0] + dp[row - 1][col - 1][1] + dp[row - 1][col - 1][2];
					}
					dp[row][col][2] = dp[row - 1][col][1] + dp[row - 1][col][2];
				}
			}
		}
		
//		for(int row = 0; row <= N; row++) {
//			for(int col = 0; col <= N; col++) {
//				System.out.print(Arrays.stream(dp[row][col]).sum() + " ");
//			}
//			System.out.println();
//		}

		int result = Arrays.stream(dp[N][N]).sum();
		System.out.println(result);
	}
}