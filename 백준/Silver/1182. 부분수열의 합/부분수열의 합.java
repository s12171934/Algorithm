import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[] list;
	public static int N,S;
	
	
	public static void main(String[] args) throws IOException {
		N = read();
		S = read();
		list = new int[N];
		for (int i = 0; i < N; i++) list[i] = read();
		
		System.out.println(DFS());
		
		
	}
	
	public static int DFS() {
		int count = 0;
		
		Stack<Node> stack = new Stack<>();
		stack.add(new Node(0, 1, false));
		stack.add(new Node(list[0], 1, true));
		
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			if(cur.num == S && cur.add) {
				count++;
			}
			if(cur.idx == N) continue;
			for(int add : new int[] {0,1}) stack.add(new Node(cur.num + add * (list[cur.idx]), cur.idx + 1, add == 1));			
		}
		
		return count;
	}
	
	public static class Node{
		int num, idx;
		boolean add;
		
		public Node(int num, int idx, boolean add) {
			this.num = num;
			this.idx = idx;
			this.add = add;
		}
	}
	
	public static int read() throws IOException {
		int res = 0;
		int mode = 1;
		while (true) {;
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			if (r == 45) {
				mode = -1;
				continue;
			}
			res = 10 * res + mode * (r - 48);
		}
	}
}