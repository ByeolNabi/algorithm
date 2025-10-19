import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long r = 31, M = 1234567891;

	public static long power(long base, int exp) {
		long res = 1;
		base %= M;
		while (exp > 0) {
			if (exp % 2 == 1)
				res = (res * base) % M;
			base = (base * base) % M;
			exp /= 2;
		}

		return res;
	}

	public static long hash_output(String str) {
		long hash_result = 0;
		for (int i = 0; i < str.length(); ++i) {
			long term = (str.charAt(i) - 'a' + 1);
			long power_of_r = power(r, i);
			hash_result = (hash_result + (term * power_of_r) % M) % M;
		}
		return hash_result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();
		String str = br.readLine();
		System.out.println(hash_output(str));
	}
}