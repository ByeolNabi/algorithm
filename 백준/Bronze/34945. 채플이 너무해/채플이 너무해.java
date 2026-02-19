import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int B = Integer.parseInt(st.nextToken());
		if(B < 6) {
			System.out.println("Oh My God!");
		}else {
			System.out.println("Success!");
		}
	}
}