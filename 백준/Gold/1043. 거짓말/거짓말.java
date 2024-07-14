import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;

    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        boolean[] check = new boolean[n + 1];
        int cnt = read();
        for (int i = 0; i < cnt; i++) {
            check[read()] = true;
        }

        ArrayList<Integer>[] lists = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            lists[i] = new ArrayList<>();
            cnt = read();
            for (int j = 0; j < cnt; j++) {
                lists[i].add(read());
            }
        }

        for (ArrayList<Integer> list : lists) {
            int n1 = list.get(0);
            for (int n2 : list) {
                union(n1, n2);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                check[getParent(i)] = true;
            }
        }

        int ans = m;
        for (ArrayList<Integer> list : lists) {
            for (int n1 : list) {
                if (check[getParent(n1)]) {
                    ans--;
                    break;
                }
            }
        }

        System.out.println(ans);


    }

    public static int getParent(int n) {
        if (n == arr[n]) return arr[n];
        else return getParent(arr[n]);
    }

    public static void union(int n1, int n2) {
        n1 = getParent(n1);
        n2 = getParent(n2);
        if (n1 < n2) arr[n2] = n1;
        else arr[n1] = n2;
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int r = br.read();
            if(r == 10 || r == 32) return res;
            res = 10 * res + r - 48;
        }
    }
}