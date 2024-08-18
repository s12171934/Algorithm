import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static Point base;

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			if(tc != 1) res.append("\n");
			base = new Point();
			StringTokenizer st = new StringTokenizer(br.readLine());
	
			int N = Integer.parseInt(st.nextToken());
			Point[] points = new Point[N];
			for (int i = 0; i < N; i++) {
				points[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), i);
			}
			Arrays.sort(points, (p1, p2) -> {
				int ccw = ccw(base, p1, p2);
				return ccw == 0 ? dist(base, p1, p2) : ccw; 
			});
			
			Stack<Point> stack = new Stack<>();
			stack.add(points[N - 1]);
			int pointer = N - 2;
			while(ccw(base, points[N -1], points[pointer]) == 0) stack.add(points[pointer--]);
			pointer = N - 1;
			while(!stack.isEmpty()) points[pointer--] = stack.pop();
			for (Point p : points) {
				res.append(p.idx).append(" ");
			}
		}
		System.out.println(res.toString());
	}
	
	static int ccw (Point base, Point p1, Point p2) {
		long ccw = (p1.x - base.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p1.y - base.y);
		return ccw == 0 ? 0 : ccw < 0 ? -1 : 1;
	}
	
	static int dist (Point base, Point p1, Point p2) {
		long dist = (long)(Math.pow(p1.x - base.x, 2) - Math.pow(p2.x - base.x, 2) + Math.pow(p1.y - base.y, 2) - Math.pow(p2.y - base.y, 2));
		return dist == 0 ? 0 : dist < 0 ? -1 : 1;
	}
	
	static class Point {
		long x = 10000;
		long y = 10000;
		int idx = 0;
		
		Point(long x, long y, int idx) {
			
			this.x = x;
			this.y = y;
			this.idx = idx;
			if ((this.x < base.x) || (this.x == base.x && this.y < base.y)) {
				base.x = this.x;
				base.y = this.y;
			}
		}
		
		Point() {}
	}
}
