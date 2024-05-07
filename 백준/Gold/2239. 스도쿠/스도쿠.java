import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();
    static ArrayList<int[]> solveArr = new ArrayList<>();
    static int[][] sudoku = new int[9][9];
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = bufferedReader.read() - 48;
                if (sudoku[i][j] == 0) solveArr.add(new int[]{i,j});
            }
            bufferedReader.read();
        }
        solveSudoku(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                stringBuilder.append(sudoku[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }

    static boolean solveSudoku(int n) {
        if (n >= solveArr.size()) return true;
        int[] solve = solveArr.get(n);
        for (int i = 1; i <= 9; i++) {
            sudoku[solve[0]][solve[1]] = i;
            if (!check(solve)) continue;
            if (solveSudoku(n + 1)) return true;
        }
        sudoku[solve[0]][solve[1]] = 0;
        return false;
    }

    static boolean check(int[] solve) {
        for (int j = 0; j < 9; j++) {
            if ((sudoku[solve[0]][solve[1]] == sudoku[solve[0]][j] && solve[1] != j)
              ||(sudoku[solve[0]][solve[1]] == sudoku[j][solve[1]] && solve[0] != j)) {
                sudoku[solve[0]][solve[1]] = 0;
                return false;
            }
        }
        int x = solve[0] / 3;
        int y = solve[1] / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[solve[0]][solve[1]] == sudoku[x * 3 + i][y * 3+ j] && solve[0] != x * 3 + i && solve[1] != y * 3 + j) {
                    sudoku[solve[0]][solve[1]] = 0;
                    return false;
                }
            }
        }


        return true;
    }
}