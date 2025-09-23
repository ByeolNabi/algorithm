import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static class Person {
		public int age;
		public String name;
		public int idx;

		public Person(int age, String name, int idx) {
			super();
			this.age = age;
			this.name = name;
			this.idx = idx;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "" + age + " " + name;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			persons.add(new Person(age, name, i));
		}

		java.util.Collections.sort(persons, (o1, o2) -> {
			int c = o1.age - o2.age;
			if (c == 0) {
				c = o1.idx - o2.idx;
			}

			return c;
		});

		for (Person p : persons) {
			System.out.println(p);
		}
	}
}