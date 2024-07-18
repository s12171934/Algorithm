import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();

        ArrayList<Node> newWall = new ArrayList<>();
        ArrayList<Node> virus = new ArrayList<>();

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = read();
                if (matrix[i][j] == 0) {
                    newWall.add(new Node(i, j));
                }
                if (matrix[i][j] == 2) {
                    virus.add(new Node(i, j));
                }
            }
        }

        int max = 0;

        for (int i = 0; i < newWall.size(); i++) {
            for (int j = i + 1; j < newWall.size(); j++) {
                for (int k = j + 1; k < newWall.size(); k++) {
                    int[][] newMatrix = matrixClone(matrix);
                    newMatrix[newWall.get(i).x][newWall.get(i).y] = 1;
                    newMatrix[newWall.get(j).x][newWall.get(j).y] = 1;
                    newMatrix[newWall.get(k).x][newWall.get(k).y] = 1;

                    Queue<Node> q = new LinkedList<>(virus);
                    int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                    int count = 0;

                    while (!q.isEmpty()) {
                        Node node = q.poll();

                        for (int[] d : deltas) {
                            int x = node.x + d[0];
                            int y = node.y + d[1];

                            if (x < 0 || x >= n || y < 0 || y >= m) continue;
                            if (newMatrix[x][y] != 0) continue;
                            newMatrix[x][y] = 2;
                            count++;

                            q.add(new Node(x, y));
                        }
                    }
                    
                    max = Math.max(max, newWall.size() - 3 - count);
                }
            }
        }

        System.out.println(max);
    }

    public static int[][] matrixClone(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = matrix[i].clone();
        }
        return newMatrix;
    }

    public static class Node{
        int x,y;

        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    // Int 입력을 위한 메서드
    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = br.read();
            if (r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}