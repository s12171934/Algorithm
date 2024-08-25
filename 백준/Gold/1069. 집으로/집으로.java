import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		int X = read();
		int Y = read();
		int D = read();
		int T = read();
		double len = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
		double moveLine = ((int)(len / D) - 1) * Math.min(D, T);
		double moveBack = D - len % D + T + (moveLine < 0 ? 0 : Math.min(D, T));
		double moveForward = Math.min(2 * T, len % D + (moveLine < 0 ? 0 : Math.min(D, T)));
		System.out.println((moveLine < 0 ? 0 : moveLine) + Math.min(moveForward, moveBack));
	}
	
	static int read() throws Exception {
		if(st == null) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
}
