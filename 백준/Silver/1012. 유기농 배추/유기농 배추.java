import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[][] board;
    static int[][] dist = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String[] str = bufferedReader.readLine().split(" ");
            int m = Integer.parseInt(str[0]);
            int n = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            board = new int[m][n];

            for (int j = 0; j < k; j++) {
                String[] pixel = bufferedReader.readLine().split(" ");
                board[Integer.parseInt(pixel[0])][Integer.parseInt(pixel[1])] = 1;
            }

            stringBuilder.append(countBugs(board)).append("\n");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static int countBugs(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    count++;
                    board[i][j] = 0;
                    DFS(i,j);
                }
            }
        }
        return count;
    }

    static void DFS(int i, int j) {
        for (int[] d : dist) {
            int dx = i + d[0];
            int dy = j + d[1];
            if(dx >= 0 && dx < board.length && dy >= 0 && dy < board[0].length && board[dx][dy] == 1) {
                board[dx][dy] = 0;
                DFS(dx,dy);
            }
        }
    }
}