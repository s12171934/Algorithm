import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	static int[] list = new int[18];
    static int[][] match = {{0,1},{0,2},{0,3},{0,4},{0,5},{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}};
	static int[][] verses = {{0,2},{1,1},{2,0}};
    
	public static void main(String[] args) throws IOException {
        for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 18; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			res.append(DFS(0) ? 1 : 0).append(" ");
		}
		System.out.println(res.toString());
	}
	
	static boolean DFS(int idx) {
		if(idx == 15) {
            for(int n : list) {
                if(n != 0) return false;
            }
            return true;
        }
		boolean result = false;
        for(int[] verse : verses){
            if(list[3*match[idx][0] + verse[0]] == 0 || list[3*match[idx][1] + verse[1]] == 0) continue;
            list[3*match[idx][0] + verse[0]]--;
            list[3*match[idx][1] + verse[1]]--;
            result = result || DFS(idx+1);
            list[3*match[idx][0] + verse[0]]++;
            list[3*match[idx][1] + verse[1]]++;
        }
		return result;
	}
}