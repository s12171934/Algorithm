import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<Integer>[] graph;
	static int N, M, scc[], id;
	static Stack<Integer> stack = new Stack<>();
	static boolean[] finished;
	
	public static void main(String[] args) throws IOException {
		id = 1;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[2 * N];
		scc = new int[2 * N];
		finished = new boolean[2 * N];
		for (int i = 0; i < 2 * N; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			n1 = n1 > 0 ? n1 - 1 : N - n1 - 1;
			n2 = n2 > 0 ? n2 - 1 : N - n2 - 1;
			graph[n1 < N ? n1 + N : n1 - N].add(n2);
			graph[n2 < N ? n2 + N : n2 - N].add(n1);
		}
		
		for (int i = 0; i < 2 * N; i++) {
			if(scc[i] != 0) continue;
			SCC(i);
		}
		for (int i = 0; i < N; i++) {
			if(scc[i] == scc[i + N]) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
	
	static int SCC(int idx) {
		stack.push(idx);
		scc[idx] = id++;
		int parent = scc[idx];
		
		for(int next : graph[idx]) {
			if(scc[next] == 0) {
				parent = Math.min(parent, SCC(next));
				continue;
			}
			if (!finished[next]) {
				parent = Math.min(parent, scc[next]);
			}
		}
		
		if(parent == scc[idx]) {
			while(!stack.isEmpty()) {
				int p = stack.pop();
				scc[p] = parent;
				finished[p] = true;
				if (p == idx) break;
			}
		}
		return parent;
	}
}
