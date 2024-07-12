import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int tc = readInt();
		
		for (int t = 0; t < tc; t++) {
			Queue<Data> queue = new LinkedList<>();
			queue.add(new Data(readInt(), ""));
			int target = readInt();
			boolean[] visited = new boolean[10000];
			
			while (!queue.isEmpty()) {
				Data data = queue.poll();
				if (data.num == target) {
					System.out.println(data.calc);
					break;
				}
				for (String str : new String[]{"D","S","L","R"}) {
					Data newData = new Data(0, data.calc + str);
					switch(str) {
						case "D":
							newData.num = cal_D(data.num);
							break;
						case "S":
							newData.num = cal_S(data.num);
							break;
						case "L":
							newData.num = cal_L(data.num);
							break;
						case "R":
							newData.num = cal_R(data.num);
							break;
					}
					if(visited[newData.num]) continue;
					visited[newData.num] = true;
					queue.add(newData);
				}
			}
		}
				
	}
	
	public static class Data{
		int num;
		String calc;
		
		public Data(int num, String calc) {
			this.num = num;
			this.calc = calc;
		}
	}
	
	public static int cal_D(int n) {
		return (2 * n) % 10000;
	}
	
	public static int cal_S(int n) {
		return (n + 9999) % 10000;
	}
	
	public static int cal_L(int n) {
		return (n * 10) % 10000 + (n * 10) / 10000;
	}
	
	public static int cal_R(int n) {
		return (n / 10) + (n % 10) * 1000;
	}
	
	public static int readInt() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 32 || r == 10) return res;
			if (r == 13) continue;
			res = 10 * res + r - 48;
		}
	}
}