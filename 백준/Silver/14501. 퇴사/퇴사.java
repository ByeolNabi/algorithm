import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] works = new int[N][2];
		int[] dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			works[i][0] = Integer.parseInt(st.nextToken());
			works[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = N - 1; i >= 0; i--) {
			int T, P;
			T = works[i][0];
			P = works[i][1];

			dp[i] = dp[i + 1];
			if (i - 1 + T < N) {
				dp[i] = Math.max(dp[i], dp[i + T] + P);
			}
		}

		System.out.println(dp[0]);
	}

}