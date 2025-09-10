import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cost_max = 0;
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, K;
		N = Integer.parseInt(st.nextToken()); // 물품의 수
		K = Integer.parseInt(st.nextToken()); // 가방의 무게

		int[][] items = new int[N][2]; // 무게, 물건의 가치

		// 메모리;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			items[i][0] = Integer.parseInt(st.nextToken());
		}
		// 코스트;
		int total_cost = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			items[i][1] = Integer.parseInt(st.nextToken());
			total_cost += items[i][1];
		}

		// 코스트를 배열로;
		int[] dp = new int[total_cost + 1];
		cost_max = INF;

		for (int i = 0; i < items.length; i++) {
			int W = items[i][0];
			int C = items[i][1];
			for (int c = total_cost; c >= C; c--) {
				dp[c] = Math.max(dp[c], dp[c - C] + W);

				if (dp[c] >= K) {
					cost_max = Math.min(cost_max, c);
				}
			}
		}

		System.out.println(cost_max);
	}
}
/*
 * 냅색이긴 한데 기준무게를 넘는 것 중에서 최소 가치
 */