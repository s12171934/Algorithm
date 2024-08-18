import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static double min;
	static Point base;

	public static void main(String[] args) throws IOException {
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			min = 20000.0;
			base = new Point();
			Point[] points = new Point[N];
			for (int i = 0; i < N; i++) {
				points[i] = new Point(br.readLine());
			}
			Arrays.sort(points, (p1, p2) -> {
				int ccw = ccw(base, p1, p2);
				return ccw == 0 ? dist(base, p1, p2) : ccw; 
			});
			
			LinkedList<Point> stack = new LinkedList<>();
			stack.addLast(points[0]);
			stack.addLast(points[1]);
			
			for (int i = 2; i < N; i++) {
				while(stack.size() >= 2 && ccw(stack.get(stack.size() - 2), stack.getLast(), points[i]) >= 0) stack.pollLast();
				stack.addLast(points[i]);
			}
			
			for (int i = 0; i < N; i++) {
				min = Math.min(min, calcMinWidth(stack));
			}
			
			res.append(String.format("Case %d: %.2f\n", tc++, Math.ceil(min * 100) / 100));
		}
		System.out.println(res.toString());
	}
	
	static double calcMinWidth(LinkedList<Point> stack) {
		Point line1 = stack.pollFirst();
		Point line2 = stack.pollFirst();
		double max = 0.0;
		
		for (Point p : stack) {
			max = Math.max(max, Math.abs((line1.x * line2.y + line2.x * p.y + p.x * line1.y) - (line1.y * line2.x + line2.y * p.x + p.y * line1.x)) / Math.sqrt(Math.pow(line1.x - line2.x, 2) + Math.pow(line1.y - line2.y, 2)));
		}
		
		stack.addLast(line1);
		stack.addFirst(line2);
		return max;
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
