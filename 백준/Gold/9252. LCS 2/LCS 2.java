import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int n = arr1.length;
        int m = arr2.length;
        int[][] matrix = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = matrix[i - 1][j];
                if(arr1[i - 1] == arr2[j - 1]) matrix[i][j] = Math.max(matrix[i][j], matrix[i - 1][j - 1] + 1);
                matrix[i][j] = Math.max(matrix[i][j], matrix[i][j -1]);
            }
        }
        sb.append(matrix[n][m]).append("\n");

        int x = m;
        int y = n;
        Stack<Character> stack = new Stack<>();
        for(int i = matrix[n][m]; i > 0; i--) {
            while (matrix[y - 1][x] == i) y--;
            while (matrix[y][x -1] == i) x--;
            stack.add(arr2[x -1]);
            x--;
            y--;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
        br.close();
    }
}