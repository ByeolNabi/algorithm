import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		
		int cnt = 0, start, end, sum;
		start = 1;
		end = 1;
		sum = start;

		while (end != target) {
			if(sum < target) {
				end++;
				sum += end;
			}else if(sum == target){
				cnt++;
				end++;
				sum += end;
			}else {
				sum -= start++;
			}
		}
		
		System.out.println(cnt+1);

	}

}