import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		final long NUMBER = 1000000007;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N, M;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		long[] dp = new long[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {

			// 뒤에서 가져오기
			dp[i] += dp[i - 1];
			dp[i] %= 1000000007;
			// 나 빼고 최선의 값 가져오기
			if (i >= M) {
				dp[i] += dp[i - M];
				dp[i] %= 1000000007;
			}
		}

//		for (int i = 0; i <= N; i++) {
//			System.out.print(dp[i] + " ");
//		}
//		System.out.println();

		System.out.println(dp[N]);

	}
}