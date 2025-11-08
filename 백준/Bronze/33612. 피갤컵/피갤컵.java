import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int y = Integer.parseInt(br.readLine());
		
		switch(y) {
		case 1:
			System.out.println("2024 8");
			break;
		case 2:
			System.out.println("2025 3");
			break;
		case 3:
			System.out.println("2025 10");
			break;
		case 4:
			System.out.println("2026 5");
			break;
		case 5:
			System.out.println("2026 12");
			break;
		}
	}
}