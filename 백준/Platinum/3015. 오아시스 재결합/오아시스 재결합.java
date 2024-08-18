import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		Stack<Node> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			Node cur = new Node(Integer.parseInt(br.readLine()));
			while(!stack.isEmpty()) {
				if(stack.peek().h < cur.h) {
					ans += stack.pop().w;
				} else if(stack.peek().h > cur.h) {
					ans ++;
					break;
				} else {
					cur.w += stack.pop().w;
					ans += cur.w - 1;
				}
			}
			stack.push(cur);
		}	
		System.out.println(ans);
	}
	
	static class Node {
		int h, w;
		Node(int h) {
			this.h = h;
			this.w = 1;
		}
	}
}
