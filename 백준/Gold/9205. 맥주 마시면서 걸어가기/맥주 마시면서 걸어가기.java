import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer[]> coors;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 편의점 갯수

			visited = new boolean[N + 2];

			coors = new ArrayList<Integer[]>();
			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				coors.add(new Integer[] { x, y });
			}

			dfs(0);
			sb.append((visited[N + 1] ? "happy" : "sad") + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int crt) {
		visited[crt] = true;

		// 탐색
		for (int nxt = 0; nxt < coors.size(); nxt++) {
			Integer[] nxtCoor = coors.get(nxt);

			if (!visited[nxt] && distance(coors.get(crt), nxtCoor) <= 1000) {
				dfs(nxt);
			}
		}
	}

	private static int distance(Integer[] coor1, Integer[] coor2) {
		return Math.abs(coor1[0] - coor2[0]) + Math.abs(coor1[1] - coor2[1]);
	}
}