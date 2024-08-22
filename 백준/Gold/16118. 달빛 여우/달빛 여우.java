import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[n1].add(new Node(n1, n2, w, 0));
			graph[n2].add(new Node(n2, n1, w, 0));
		}
		int count = 0;
		int[] fox = new int[N + 1];
		Arrays.fill(fox, INF);
		int[][] wolf = new int[2][N + 1];
		Arrays.fill(wolf[0], INF);
		Arrays.fill(wolf[1], INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
		pq.add(new Node(1,0,0,0));
		wolf[0][1] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if (wolf[cur.idx / 2][cur.n1] < cur.w) continue;
			int otherIdx = Math.abs(cur.idx - 2) / 2; 
			for (Node next : graph[cur.n1]) {
				int newWeight = (next.w << cur.idx) + wolf[cur.idx / 2][cur.n1];
				if(wolf[otherIdx][next.n2] <= newWeight) continue;
				wolf[otherIdx][next.n2] = newWeight;
				pq.add(new Node(next.n2, 0, wolf[otherIdx][next.n2], otherIdx * 2));
			}
		}
		
		pq.add(new Node(1,0,0,1));
		fox[1] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if (fox[cur.n1] < cur.w) continue;
			if (fox[cur.n1] < Math.min(wolf[0][cur.n1], wolf[1][cur.n1])) count++;
			for (Node next : graph[cur.n1]) {
				int newWeight = (next.w << 1) + fox[cur.n1];
				if(fox[next.n2] <= newWeight) continue;
				fox[next.n2] = newWeight;
				pq.add(new Node(next.n2, 0, fox[next.n2], cur.idx));
			}
		}
	
		System.out.println(count);
	}
	
	static class Node {
		int n1, n2, w, idx;
		Node(int n1, int n2, int w, int idx) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
			this.idx = idx;
		}
	}
}
