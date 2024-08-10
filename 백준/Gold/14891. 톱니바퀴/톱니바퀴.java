import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] gears = new int[4];
	
	public static void main(String[] args) throws IOException {	
		for (int i = 0; i < 4; i++) {
			gears[i] = Integer.parseInt(br.readLine(), 2);
		}
		
		int N = read();
		
		for (int i = 0; i < N; i++) {
			moveGear(read() -1, read(), true, true);
		}
		
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			ans += (gears[i] & (1 << 7)) != 0 ? 1 << i : 0;
		}
		System.out.println(ans);
	}
	
	static void moveGear(int gear, int dist, boolean before, boolean after) {
		if (gear != 0 && before) {
			if (((gears[gear] & (1 << 1)) != 0) ^ ((gears[gear - 1] & (1 << 5)) != 0)) moveGear(gear - 1, -1 * dist, true, false);
		}
		if (gear != 3 && after) {
			if (((gears[gear] & (1 << 5)) != 0) ^ ((gears[gear + 1] & (1 << 1)) != 0)) moveGear(gear + 1, -1 * dist, false, true);
		}
		if (gear < 0 || gear > 3) return;
		
		if (dist < 0) {
			gears[gear] = (gears[gear] << 1) + ((gears[gear] & (1 << 7)) != 0 ? 1 - (1 << 8) : 0);
		}
		else {
			gears[gear] = (gears[gear] >> 1) + ((gears[gear] % 2) != 0 ? 1 << 7 : 0);
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
