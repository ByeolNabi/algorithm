import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Tmt {
		int h, r, c, dist;

		public Tmt(int h, int r, int c, int dist) {
			super();
			this.h = h;
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}

	// 동서남북아래위
	static int[] dh = new int[] { 0, 0, 0, 0, 1, -1 };
	static int[] dr = new int[] { 0, 0, 1, -1, 0, 0 };
	static int[] dc = new int[] { 1, -1, 0, 0, 0, 0 };
	static int tmtcnt = 0;
	static int M, N, H;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // col
		N = Integer.parseInt(st.nextToken()); // row
		H = Integer.parseInt(st.nextToken()); // height

		int[][][] map = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];

		Queue<Tmt> q = new ArrayDeque<Tmt>();

		for (int h = 0; h < H; h++) {
			for (int row = 0; row < N; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < M; col++) {
					map[h][row][col] = Integer.parseInt(st.nextToken());
					// 1 : 익은토마토, 0 : 익지 않은 토마토, -1 : 토마토 없어
					if (map[h][row][col] == 0) {
						tmtcnt++;
					} else if (map[h][row][col] == 1) {
						q.add(new Tmt(h, row, col, 0));
					}
				}
			}
		}

		// bfs 토마토
		int tmtdays = 0;
		while (!q.isEmpty()) {
			Tmt crt_tmt = q.poll();
			tmtdays = Math.max(crt_tmt.dist, tmtdays);

			for (int i = 0; i < 6; i++) {
				Tmt nxt_tmt = new Tmt(crt_tmt.h + dh[i], crt_tmt.r + dr[i], crt_tmt.c + dc[i], crt_tmt.dist + 1);
				if (inChecker(nxt_tmt) && !visited[nxt_tmt.h][nxt_tmt.r][nxt_tmt.c]
						&& map[nxt_tmt.h][nxt_tmt.r][nxt_tmt.c] == 0) {
					q.add(nxt_tmt);
					visited[nxt_tmt.h][nxt_tmt.r][nxt_tmt.c] = true;
					tmtcnt--;
				}
			}
		}

		if (tmtcnt != 0) {
			System.out.println(-1);
		} else {
			System.out.println(tmtdays);
		}
	}

	static boolean inChecker(Tmt tmt) {
		if (0 <= tmt.h && tmt.h < H && 0 <= tmt.r && tmt.r < N && 0 <= tmt.c && tmt.c < M) {
			return true;
		} else {
			return false;
		}
	}
}