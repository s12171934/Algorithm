import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = read();
		int K = read();
		char[] list = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			while(!stack.isEmpty() && K != 0 && stack.peek() < list[i]) {
				stack.pop();
				K--;
			}
			if(K == 0) {
				for (char c : stack) res.append(c);
				for (int j = i; j < N; j++) res.append(list[j]);
				System.out.println(res.toString()); 
				return;
			}
			stack.push(list[i]);
		}
		for(int i = 0; i < K; i++) {
			stack.pop();
		}
		for(char c : stack) res.append(c);
		System.out.println(res.toString()); 
 	}
	
	static int read() throws IOException {
		int res = 0;
		while(true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}
