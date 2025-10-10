import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		while(true) {
			int numb = Integer.parseInt(br.readLine());
			
			if(numb == 0) {
				break;
			}
			
			if(numb%n == 0) {
				System.out.println(numb + " is a multiple of " + n + ".");
			}else {
				System.out.println(numb + " is NOT a multiple of " + n + ".");
			}
		}
	}
}