import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Point base = new Point();


	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			points[i] = new Point(br.readLine());
		}
		Arrays.sort(points, (p1, p2) -> {
			int ccw = ccw(base, p1, p2);
			return ccw == 0 ? dist(base, p1, p2) : ccw; 
		});
		
		Stack<Point> stack = new Stack<>();
		stack.add(points[0]);
		stack.add(points[1]);
		
		for (int i = 2; i < N; i++) {
			while(stack.size() >= 2 && ccw(stack.get(stack.size() - 2), stack.peek(), points[i]) >= 0) stack.pop();
			stack.push(points[i]);
		}
		
		System.out.println(stack.size());
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
		long x = 40000;
		long y = 40000;
		
		Point(String str) {
			StringTokenizer st = new StringTokenizer(str);
			this.x = Long.parseLong(st.nextToken());
			this.y = Long.parseLong(st.nextToken());
			if ((this.x < base.x) || (this.x == base.x && this.y < base.y)) {
				base.x = this.x;
				base.y = this.y;
			}
		}
		
		Point() {}
	}
}
