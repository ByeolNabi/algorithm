import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		final long MOD = 10007;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N;
		N = Integer.parseInt(br.readLine());

		long[] dp = new long[N + 2];
		dp[1] = 1;
		dp[2] = 2;
		if (dp[N] != 0) {
			System.out.println(dp[N]);
			return;
		}

		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
		}

		System.out.println(dp[N]);

	}
}