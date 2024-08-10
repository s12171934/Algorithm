import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, H;
	
	public static void main(String[] args) throws IOException {	
		N = read();
		M = read();
		H = read();
		int[] row = new int[H + 1];
		for (int i = 0; i < M; i++) {
			row[read()] |= 1 << read();
		}
		
		if(check(row)) {
			System.out.println(0);
			return;
		}
		
		int max = (H + 1) * N;
		
		for (int i = N; i < max; i++) {
			if (isSet(i, row[i / N])) continue;
			int[] newRow = row.clone();
			newRow[i / N] |= 1 << (i % N);
			if(check(newRow)) {
				System.out.println(1);
				return;
			}
		}
		
		for (int i = N; i < max; i++) {
			if (isSet(i, row[i / N])) continue;
			int[] newRow = row.clone();
			newRow[i / N] |= 1 << (i % N);
			
			for (int j = i + 1; j < max; j++) {
				if (isSet(j, newRow[j / N])) continue;
				int[] new2Row = newRow.clone();
				new2Row[j / N] |= 1 << (j % N);
				if(check(new2Row)) {
					System.out.println(2);
					return;
				}
			}
		}
		
		for (int i = N; i < max; i++) {
			if (isSet(i, row[i / N])) continue;
			int[] newRow = row.clone();
			newRow[i / N] |= 1 << (i % N);
			
			for (int j = i + 1; j < max; j++) {
				if (isSet(j, newRow[j / N])) continue;
				int[] new2Row = newRow.clone();
				new2Row[j / N] |= 1 << (j % N);
				
				for (int k = j + 1; k < max; k++) {
					if (isSet(k, new2Row[k / N])) continue;
					int[] new3Row = new2Row.clone();
					new3Row[k / N] |= 1 << (k % N);
					if(check(new3Row)) {
						System.out.println(3);
						return;
					}
				}
			}
		}
		
		System.out.println(-1);
	}
	
	static boolean isSet(int i, int target) { 
		return i % N == 0 || (target & ((1 << (i % N)) | (1 << (i % N - 1)) | (1 << (i % N + 1)))) != 0;
	}
	
	static boolean check(int[] row) {
		for (int i = 1; i < N; i++) {
			int now = i;
			for (int j = 1; j <= H; j++) {
				if((row[j] & (1 << now)) != 0) now++;
				else if((row[j] & (1 << (now -1))) != 0) now--;
			}
			if(now != i) return false;
		}
		return true;
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
