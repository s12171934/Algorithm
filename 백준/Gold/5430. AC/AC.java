import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		
		int TC = readInt();
		
		for (int t = 0; t < TC; t++) {
			char[] order = br.readLine().toCharArray();
			int len = readInt();
			String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
			
			boolean front = true;
			int s = 0;
			int e = 0;

			for (char c : order) {
				if (c == 'R') {
					front = !front;
				}
				else {
					if(front) {
						s++;
					}
					else e++;
				}
			}
			
			if(s + e > len) {
				System.out.println("error");
			}
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if (front) {
					for (int i = s; i < len - e; i++) {
						sb.append(arr[i]).append(",");
					}
				}
				else {
					for (int i = len - e - 1; i >= s; i--) {
						sb.append(arr[i]).append(",");
					}
				}
				if(sb.length() > 1) {
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append("]");
				System.out.println(sb);
				
			}
	
		}
		
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
