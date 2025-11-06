import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] result = new int[2][3]; // 0 max, 1 min
		int[] inputNum = new int[3];
		int[][] tmp = new int[2][3];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				inputNum[c] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					result[0][i] = Math.max(tmp[0][i], tmp[0][i + 1]) + inputNum[i];
					result[1][i] = Math.min(tmp[1][i], tmp[1][i + 1]) + inputNum[i];
				} else if (i == 2) {
					result[0][i] = Math.max(tmp[0][i - 1], tmp[0][i]) + inputNum[i];
					result[1][i] = Math.min(tmp[1][i - 1], tmp[1][i]) + inputNum[i];
				} else {
					int maxVal = Math.max(Math.max(tmp[0][i - 1], tmp[0][i]), tmp[0][i + 1]);
					result[0][i] = maxVal + inputNum[i];
					int minVal = Math.min(Math.min(tmp[1][i - 1], tmp[1][i]), tmp[1][i + 1]);
					result[1][i] = minVal + inputNum[i];
				}
			}

			for (int i = 0; i < 3; i++) {
				tmp[0][i] = result[0][i];
				tmp[1][i] = result[1][i];
			}
		}

		System.out.println(Arrays.stream(result[0]).max().getAsInt() + " " + Arrays.stream(result[1]).min().getAsInt());

	}
}