import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int map[][];
	public static int tc;
	public static boolean goal = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		tc = Integer.parseInt(br.readLine());

		map = new int[tc][tc];
		for (int i = 0; i < tc; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);

			for (int j = 0; st.hasMoreTokens(); j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(0,0);
		
		if(goal) {
			System.out.println("HaruHaru");
		}else {
			System.out.println("Hing");
		}

//		System.out.println(Arrays.deepToString(map));
	}

	public static void BFS(int r, int c) {
//		System.out.println(r + " " + c);
		
		if(goal) {
			return;
		}
		if(map[r][c] == -1) {
			goal = true;
			return;
		}
		if (map[r][c] == 0) {
			return;
		}
		// 아래
		if (canGo(r + map[r][c], c)) {
			BFS(r + map[r][c], c);
		}
		
		// 오른쪽
		if (canGo(r, c + map[r][c])) {
			BFS(r, c + map[r][c]);
		}
		
		return;
	}

	public static boolean canGo(int r, int c) {
//		System.out.println(r + " " + c);
		
		if (r >= tc || r < 0) {
			return false;
		}
		if (c >= tc || c < 0) {
			return false;
		}

		return true;
	}

}