import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken()); // 물품의 수
		K = Integer.parseInt(st.nextToken()); // 가방의 무게

		int[] dp = new int[K + 1];
		int[][] items = new int[N][2]; // 무게, 물건의 가치

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w, v;
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < items.length; i++) {
			for (int w = K; w >= items[i][0]; w--) {
				int W = items[i][0];
				int V = items[i][1];
				dp[w] = Math.max(dp[w], dp[w - W] + V);
			}
		}

		System.out.println(dp[K]);
	}
}