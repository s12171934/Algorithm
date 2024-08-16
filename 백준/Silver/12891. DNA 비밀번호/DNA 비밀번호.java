import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		int S = read();
		int P = read();
		char[] dna = br.readLine().toCharArray();
		int[] list = {-1 * read(), -1 * read(), -1 * read(), -1 * read()};
		for(int i = 0; i < P; i++) {
			list[findIdx(dna[i])]++;
		}
		check(list);
		for(int i = P; i < S; i++) {
			list[findIdx(dna[i - P])]--;
			list[findIdx(dna[i])]++;
			check(list);
		}
		System.out.println(cnt);
	}
	
	static void check(int[] list) {
		for(int i : list) {
			if(i < 0) return;
		}
		cnt++;
	}
	
	static int findIdx(char c) {
		switch(c) {
		case 'A' :
			return 0;
		case 'C' :
			return 1;
		case 'G' :
			return 2;
		default:
			return 3;
		}
	}
	
	static int read() throws IOException {
		int res = 0;
		while (true) {
			int r = br.read();
			if (r == 10 || r == 32) return res;
			if (r == 13) continue;
			res = 10 * res + (r - 48);
		}
	}
}