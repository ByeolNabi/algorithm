import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	public Node() {

	}

	public Node(int data) {
		this.data = data;
		prev = this;
		next = this;
	}

	public Node(int data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public void delete() {
		prev.next = next;
		next.prev = prev;
	}

	int data;
	Node prev;
	Node next;

	@Override
	public String toString() {
		return String.format("data : %d", this.data);
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Node firstNode = new Node(1);
		firstNode.prev = firstNode;
		firstNode.next = firstNode;
		Node crtNode = firstNode;
		// 다음거 연결하고 현재노드를 바꾸기
		for (int i = 2; i <= N; i++) {
			crtNode.next = new Node(i, crtNode, firstNode);
			crtNode = crtNode.next;
//			System.out.println(crtNode);
		}

		firstNode.prev = crtNode;
		crtNode.next = firstNode;

		// -----------

		crtNode = firstNode;
		List<Integer> answer = new ArrayList<>();
		while (answer.size() != N) {
//			System.out.println(answer);
			for (int i = 0; i < K - 1; i++) {
				crtNode = crtNode.next;
			}
			answer.add(crtNode.data);
//			System.out.println(crtNode.prev.data + " " + crtNode.next.data);
			crtNode.delete();
			crtNode = crtNode.next;
			
		}
		
		System.out.print("<"+answer.get(0));
		for(int i = 1; i < answer.size(); i++) {
			System.out.print(", " + answer.get(i));
		}
		System.out.print(">");

	}
}

// node 1부터 하면 2칸 뒤가 3이고 3에서 3칸 뒤가 6임 -> delete하고 현재 포커싱을 한 칸 앞으로 옮김
// delete하는 과정에서 prev의 next를 crt의 next에 저장했는데 prev는 업데이트 안 해서 곤란해짐