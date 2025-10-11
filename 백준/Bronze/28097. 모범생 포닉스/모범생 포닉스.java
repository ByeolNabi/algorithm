import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < t; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			sum += tmp + 8;
		}
		sum -= 8;

		System.out.println(sum / 24 + " " + sum % 24);
	}

}