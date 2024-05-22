import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        char[] row = bufferedReader.readLine().toCharArray();
        char[] col = bufferedReader.readLine().toCharArray();
        int[][] matrix = new int[col.length + 1][row.length + 1];

        int colNum = 1;
        for (char c : col) {
            int rowNum = 1;
            int l = 0;
            for (char r : row) {
                l = Math.max(l, matrix[colNum - 1][rowNum]);
                if(c == r) {
                    l = matrix[colNum - 1][rowNum - 1] + 1;
                }
                matrix[colNum][rowNum] = l;
                rowNum++;
            }
            colNum++;
        }

        System.out.println(matrix[col.length][row.length]);
        bufferedReader.close();
    }
}