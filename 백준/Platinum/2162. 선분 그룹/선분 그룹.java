import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static int[][] lines;

    public static void main(String[] args) throws IOException {
        int n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        lines = new int[n][4];
        for (int i = 0; i < n; i++) {
            lines[i][0] = read();
            lines[i][1] = read();
            lines[i][2] = read();
            lines[i][3] = read();
        }

        for (int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(cross(i,j)) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            getParent(i);
        }

        Arrays.sort(arr);
        int group = 1;
        int max = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i - 1] == arr[i]) {
                count++;
            }
            else {
                group++;
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);

        System.out.println(group);
        System.out.println(max);
    }

    public static int getParent(int i) {
        if(arr[i] == i) return i;
        return arr[i] = getParent(arr[i]);
    }

    public static void union(int i, int j) {
        i = getParent(i);
        j = getParent(j);
        arr[j] = i;
    }

    public static boolean cross(int i, int j) {
        int ix1 = lines[i][0], iy1 = lines[i][1], ix2 = lines[i][2] , iy2 = lines[i][3];
        int jx1 = lines[j][0], jy1 = lines[j][1], jx2 = lines[j][2] , jy2 = lines[j][3];

        long a = crossPoint(ix1, ix2, iy1, iy2, jx1, jy1);
        long b = crossPoint(ix1, ix2, iy1, iy2, jx2, jy2);
        long c = crossPoint(jx1, jx2, jy1, jy2, ix1, iy1);
        long d = crossPoint(jx1, jx2, jy1, jy2, ix2, iy2);
        boolean crossed = a * b <= 0 && c * d <= 0;

        if((ix1 - ix2) * (jy1 - jy2) == (iy1 - iy2) * (jx1 - jx2)) {
            if(ix1 - ix2 != 0) {
                crossed = crossed
                        && ((ix1 - jx1) * (ix2 - jx1) <= 0
                        || (ix1 - jx2) * (ix2 - jx2) <= 0
                        || (ix1 - jx1) * (ix1 - jx2) <= 0
                        || (ix2 - jx1) * (ix2 - jx1) <= 0);
            }
            else {
                crossed = crossed
                        && ((iy1 - jy1) * (iy2 - jy1) <= 0
                        || (iy1 - jy2) * (iy2 - jy2) <= 0
                        || (iy1 - jy1) * (iy1 - jy2) <= 0
                        || (iy2 - jy1) * (iy2 - jy1) <= 0);
            }
        }

        return crossed;
    }

    public static long crossPoint(int x1, int x2, int y1, int y2, int a, int b) {
        return (long) (x1 - x2) * (b - y1) - (long) (y1 - y2) * (a - x1);
    }


    public static int read() throws IOException {
        int res = 0;
        int mod = 1;

        while (true) {
            int n = br.read();
            if (n == 10 || n == 32) return res;
            if (n == 45) {
                mod = -1;
                continue;
            }
            res = res * 10 + mod * ( n - 48 );
        }
    }
}