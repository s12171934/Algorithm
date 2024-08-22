import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N , cnt;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		NQueen(1, 0);
		System.out.println(cnt);
	}
	
	static void NQueen(int idx, long map) {
		if(idx > N) {
			cnt++;
			return;
		}
		loop: for (int i = 0; i < N; i++) {
			if((map & (15l << (i * 4))) != 0) continue loop;
			for (int j = 0; j < N; j++) {
				long idx2 = ((map & (15l << (j * 4))) >> (j * 4));
				if(idx2 == 0) continue;
				if(Math.abs(idx2 - idx) == Math.abs(i - j)) continue loop;
			}
			NQueen(idx + 1, map | (((long)idx) << (i * 4)));
		}
	}
}
