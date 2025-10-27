import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] op;
	static int[] numbs;
	static int min = 1111111111;
	static int max = -1111111111;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		numbs = new int[n];

		for (int i = 0; i < n; i++) {
			numbs[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		// 덧셈, 뺼셈, 곱셈, 나눗셈
		op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, numbs[0]);

		System.out.println(max + "\n" + min);
	}

	public static void dfs(int depth, int val) {
		if (depth >= n - 1) {
			min = Math.min(min, val);
			max = Math.max(max, val);
		}

		// 덧셈, 뺼셈, 곱셈, 나눗셈
		if (op[0] > 0) {
			op[0]--;
			dfs(depth + 1, val + numbs[depth + 1]);
			op[0]++;
		}
		if (op[1] > 0) {
			op[1]--;
			dfs(depth + 1, val - numbs[depth + 1]);
			op[1]++;
		}
		if (op[2] > 0) {
			op[2]--;
			dfs(depth + 1, val * numbs[depth + 1]);
			op[2]++;
		}
		if (op[3] > 0) {
			op[3]--;
			dfs(depth + 1, val / numbs[depth + 1]);
			op[3]++;
		}
	}
}