import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayDeque<String> deque = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cnt = st.countTokens() / 2 - 1;
			while (st.hasMoreTokens()) {
				String next = st.nextToken();
				if (next.equals("X") && cnt > 0) {
					deque.addLast("(" + deque.pollLast() + " X " + st.nextToken() + ")");
					cnt--;
				}
				else {
					deque.addLast(next);
				}
			}
			while (deque.size() != 3) {
				deque.addFirst("(" + deque.pollFirst() + " " + deque.pollFirst() + " " + deque.pollFirst() + ")");
			}
			System.out.println(deque.pollFirst() + " " + deque.pollFirst() + " " + deque.pollFirst() + "\n");
		}
	}
}