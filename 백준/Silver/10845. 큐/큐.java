import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
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

		Deque<Integer> stk = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String cmd = st.nextToken();
			
			switch (cmd) {
			case "push":
				stk.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stk.isEmpty()) {
					sb.append(-1 + "\n");
					break;
				}else {
					sb.append(stk.pollFirst() + "\n");
					break;
				}
			case "size":
				sb.append(stk.size() + "\n");
				break;
			case "empty":
				sb.append((stk.isEmpty() ? 1 : 0) + "\n");
				break;
			case "front":
				if(stk.isEmpty()) {
					sb.append(-1 + "\n");
					break;
				}else {
					sb.append(stk.peekFirst() + "\n");
					break;
				}
			case "back":
				if(stk.isEmpty()) {
					sb.append(-1 + "\n");
					break;
				}else {
					sb.append(stk.peekLast() + "\n");
					break;
				}
			}

		}

		System.out.println(sb);
	}
}