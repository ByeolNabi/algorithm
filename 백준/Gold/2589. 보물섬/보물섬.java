import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static char[][] map;
	public static int 행, 열;

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static int far = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		행 = Integer.parseInt(st.nextToken());
		열 = Integer.parseInt(st.nextToken());

		map = new char[행][열];

		for (int r = 0; r < 행; r++) {
			String tmp = br.readLine();
			for (int c = 0; c < 열; c++) {
				map[r][c] = tmp.charAt(c);
			}
		}

		for (int r = 0; r < 행; r++) {
			for (int c = 0; c < 열; c++) {
				Integer[] coor = { r, c, 0 };
				if (map[r][c] == 'W')
					continue;
				bfs(coor);

			}
		}

		System.out.println(far);

	}

	public static void bfs(Integer[] coor) {
		boolean[][] visited = new boolean[행][열];

		Queue<Integer[]> q = new ArrayDeque<Integer[]>();
		q.offer(coor);
		visited[coor[0]][coor[1]] = true;

		while (!q.isEmpty()) {
			Integer[] crt = q.poll();

			if (far < crt[2]) {
				far = crt[2];
			}

			for (int i = 0; i < 4; i++) {
				Integer[] nxt = { crt[0] + dy[i], crt[1] + dx[i], crt[2] + 1 };

				if (nxt[0] < 0 || 행 <= nxt[0] || nxt[1] < 0 || 열 <= nxt[1])
					continue;
				if (map[nxt[0]][nxt[1]] == 'W')
					continue;
				if (visited[nxt[0]][nxt[1]])
					continue;

				q.offer(nxt);
				visited[nxt[0]][nxt[1]] = true;
			}
		}

	}
}