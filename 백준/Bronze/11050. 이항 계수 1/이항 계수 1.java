import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, k;
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int top = 1;

		System.out.println(bin(n, k));
	}

	private static int bin(int n, int k) {

		if (n == 0 || k == 0 || n == k) {
			return 1;
		} else {
			//			System.out.println((n - 1) + " " + (k - 1));
			return bin(n - 1, k - 1) + bin(n - 1, k);
		}
	}

}