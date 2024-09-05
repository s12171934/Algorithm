import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] check;
	static Node[] list;
	
	static int read() throws Exception {
		if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static class Node{
		ArrayList<Integer> low = new ArrayList<>();
		ArrayList<Integer> high = new ArrayList<>();
	}
	
	static int countHigh(int i) {
		int sum = 0;
		for (int next : list[i].high) {
			if(check[next]) continue;
			check[next] = true;
			sum += countHigh(next) + 1;
		}
		return sum;
	}
	
	static int countLow(int i) {
		int sum = 0;
		for (int next : list[i].low) {
			if(check[next]) continue;
			check[next] = true;
			sum += countLow(next) + 1;
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		int N = read();
		int M = read();
		list = new Node[N + 1];
		for (int i = 1; i <= N; i++) list[i] = new Node();
		for (int i = 1; i <= M; i++) {
			int high = read();
			int low = read();
			list[high].low.add(low);
			list[low].high.add(high);
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			check = new boolean[N + 1];
			int n = countHigh(i) + countLow(i);
			if (n == N - 1) cnt++;
		}
		System.out.println(cnt);
	}
}