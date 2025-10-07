import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int cut(long length, long[] numbs) {
		int result = 0;
		for (long n : numbs) {
			result += n / length;
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int K, N;
		K = Integer.parseInt(st.nextToken()); // K 입력받을 랜선 갯수
		N = Integer.parseInt(st.nextToken()); // N 만들어야하는 랜선 갯수
		long[] numbs = new long[K];

        long max = 0;
		for (int i = 0; i < K; i++) {
			numbs[i] = Long.parseLong(br.readLine());
            max = Math.max(numbs[i], max);
		}
		long left, right, middle;
		left = 1;
		right = max;
        
        long result = 0;
		while (left <= right) {
            middle = (left + right) / 2;
			int stick = cut(middle, numbs);
//			System.out.println(stick + " : " + left + " " + middle + " " + right);
			if (stick >= N) { // 같거나 필요 이상으로 잘렸으면 랜선 길이를 늘려야한다.
				// middle 값 늘리기
                result = middle;
				left = middle + 1;
				
			} else { // 잘린 stick이 적으면 랜선 길이를 줄여야한다.
				// middle 값 줄이기
				right = middle - 1;
			}
		}
		
		System.out.println(result);
	}
}

// 랜선의 최대 길이 구하기
// 숫자 하나 골라서 N개 만들 수 있는지 잘라보기
// 잘라본 갯수가 K보다 같거나 크면 참, K보다 작으면 거짓
// 참 값 중에서 가장 큰 값 찾

// 길이 짧음, N 많음 <> 길이값 큼, N 적음