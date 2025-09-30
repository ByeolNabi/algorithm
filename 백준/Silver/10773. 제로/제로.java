import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		Stack<Long> stk = new Stack<>();
		for (int i = 0; i < N; i++) {
			long tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				stk.pop();
			}else {
				stk.push(tmp);
			}
		}

		while(!stk.isEmpty()) {
			sum += stk.pop();
		}
		
		System.out.println(sum);
	}
}