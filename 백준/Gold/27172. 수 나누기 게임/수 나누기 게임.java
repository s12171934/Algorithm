import java.io.*;
import java.util.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int N = read();
		Node[] list = new Node[1_000_001];
		Node[] list2 = new Node[N];
		for (int i = 0; i < N; i++) { 
			int num = read();
			list[num] = new Node(i,num,0);
			list2[i] = list[num];
		}
		
		for (int i = 0; i < 1_000_001; i++) {
			if(list[i] == null) continue;
			int count = 2;
			while (count * i < 1_000_001) {
				if(list[i * count] != null) {
					list[i].rate++;
					list[i * count].rate--;
				}
				count++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Node n : list2) sb.append(n.rate).append(" ");
		System.out.println(sb);
	}
	
	public static class Node {
		int index, num, rate;
		
		public Node(int index, int num, int rate) {
			this.index = index;
			this.num = num;
			this.rate = rate;
		}
	}
	
	public static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}