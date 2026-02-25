import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 
		 st = new StringTokenizer(br.readLine());
		 
		 String s = st.nextToken();
		 
		 char c = s.charAt(0);
		 switch(c) {
		 case 'F':
			 System.out.println("Foundation");
			 break;
		 case 'C':
			 System.out.println("Claves");
			 break;
		 case 'V':
			 System.out.println("Veritas");
			 break;
		 case 'E':
			 System.out.println("Exploration");
			 break;
		 }
	}	
}