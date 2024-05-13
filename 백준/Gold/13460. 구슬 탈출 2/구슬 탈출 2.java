import java.io.*;
        import java.util.*;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int[][] data;
    static int[] exit;
    public static void main(String[] args) throws Exception {
        String[] str = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        data = new int[3][2];
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++){
            char[] chars = bufferedReader.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (chars[j] == '#') continue;
                map[i][j] = true;
                if (chars[j] == 'R') data[0] = new int[]{i,j};
                if (chars[j] == 'B') data[1] = new int[]{i,j};
                if (chars[j] == 'O') exit = new int[]{i,j};
            }
        }
        data[2][1] = 5;

        int times  = -1;
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(data);
        while (!queue.isEmpty()){
            data = queue.poll();
            if(data[2][0] >= 10) continue;
            if(data[1][0] == 0) continue;
            for (int i = 0; i < 4; i++) {
                if (data[2][1] / 2 == i / 2) continue;
                int[][] newData = new int[3][2];
                newData[2][0] = data[2][0] + 1;
                newData[2][1] = i;
                for(int j : ballOrder(x[i],y[i])) {
                    int by = data[j][0];
                    int bx = data[j][1];
                    boolean isExit = false;
                    while (map[by + y[i]][bx + x[i]] && !(by + y[i] == newData[1 - j][0] && bx + x[i] == newData[1 - j][1])) {
                        by += y[i];
                        bx += x[i];

                        if(exit[0] == by && exit[1] == bx) {
                            if (j == 0) times = newData[2][0];
                            else times = -1;
                            isExit = true;
                        }
                    }
                    if (isExit) {
                        newData[j] = new int[]{0, 0};
                        if (j == 1) break;
                    }
                    else newData[j] = new int[]{by, bx};
                }
                if (times != -1) break;
                queue.add(newData);
            }
            if (times != -1) break;
        }

        System.out.println(times);

        bufferedReader.close();
    }

    static int[] ballOrder(int x, int y) {
        int[] redFirst = new int[]{0,1};
        int[] blueFirst = new int[]{1,0};
        if (y == 0) {
            if (x == 1) return data[0][1] > data[1][1] ? redFirst : blueFirst;
            else return data[0][1] < data[1][1] ? redFirst : blueFirst;
        }
        else if (y == 1) return data[0][0] > data[1][0] ? redFirst : blueFirst;
        else return data[0][0] < data[1][0] ? redFirst : blueFirst;
    }

}