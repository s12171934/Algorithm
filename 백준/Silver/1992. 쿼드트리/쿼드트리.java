import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long[] matrix;
	static int nxs, nxe, nys, nye;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		matrix = new long[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if(str.charAt(j) == '1') matrix[i] |= 1l << (N - 1 - j);
			}
		}
		System.out.println(quadTree(0, N, 0, N));
	}
	
	static String quadTree(int xs, int xe, int ys, int ye) {
		if(xs == xe - 1) {
			return (matrix[xs] & (1l << ys)) == 0 ? "0" : "1";
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('(');
		for (int d = 0; d < 4; d++) {
			switch(d) {
			case 0:
				nxs = xs;
				nxe = (xs + xe) / 2;
				nys = (ys + ye) / 2;
				nye = ye;
				break;
			case 1:
				nxs = xs;
				nxe = (xs + xe) / 2;
				nys = ys;
				nye = (ys + ye) / 2;
				break;
			case 2:
				nxs = (xs + xe) / 2;
				nxe = xe;
				nys = (ys + ye) / 2;
				nye = ye;
				break;
			case 3:
				nxs = (xs + xe) / 2;
				nxe = xe;
				nys = ys;
				nye = (ys + ye) / 2;
				break;
			}
			sb.append(quadTree(nxs,nxe,nys,nye));
		}
		sb.append(')');
		if(sb.toString().equals("(0000)")) return "0";
		if(sb.toString().equals("(1111)")) return "1";
		return sb.toString();
	}
}
