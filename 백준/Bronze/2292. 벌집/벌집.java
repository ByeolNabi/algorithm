import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int target = Integer.parseInt(br.readLine());
		target--;

		int shell = 0;
		while (true) {
			if (target <= 6 * shell) {
				break;
			}
			target = target - (shell * 6);
			shell++;
		}

		System.out.println(shell + 1);
	}
}