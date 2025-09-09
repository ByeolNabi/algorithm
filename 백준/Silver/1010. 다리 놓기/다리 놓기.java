import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N, M;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// dp초기값
			dp = new int[32][32];
			for (int i = 0; i <= M; i++) {
				dp[i][0] = 1;
				dp[i][i] = 1;
			}

			// mCn을 구하면 된다. 이항계수 dp
			sb.append(recur(M, N) + "\n");
//			System.out.println();
//			for(int i = 0; i <=M; i++) {
//				System.out.println(Arrays.toString(dp[i]));
//			}
		}

		System.out.println(sb);

	}

	static int recur(int frontNum, int rearNum) {
		if (dp[frontNum][rearNum] != 0) {
			return dp[frontNum][rearNum];
		} else {
			dp[frontNum][rearNum] = recur(frontNum - 1, rearNum - 1) + recur(frontNum - 1, rearNum);
		}

		return dp[frontNum][rearNum];
	}
}