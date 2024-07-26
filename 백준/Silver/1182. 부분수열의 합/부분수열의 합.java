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
		int count = S == 0 ? -1 : 0;
		
		Stack<int[]> stack = new Stack<>();
		stack.add(new int[] {0,1});
		stack.add(new int[] {list[0],1});
		
		while (!stack.isEmpty()) {
			int[] cur = stack.pop();
			if(cur[1] == N) {
				if(cur[0] == S) count++;
				continue;
			}
			for(int add : new int[] {0,1}) stack.add(new int[] {cur[0] + add * list[cur[1]], cur[1] + 1});			
		}
		
		return count;
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