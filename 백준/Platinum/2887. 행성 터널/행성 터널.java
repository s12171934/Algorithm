import java.io.*;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] planets;

    public static void main(String[] args) throws IOException {
        int n = read();
        int[][] xyz = new int[n][4];
        for (int i = 0; i < n; i++) {
            xyz[i][0] = read();
            xyz[i][1] = read();
            xyz[i][2] = read();
            xyz[i][3] = i;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int a = i;
            Arrays.sort(xyz,Comparator.comparingInt(v -> v[a]));
            for (int j = 0; j < n - 1; j++) {
                int min = Math.abs(xyz[j][i] - xyz[j + 1][i]);
                nodes.add(new Node(xyz[j][3], xyz[j + 1][3], min));
            }
        }
        nodes.sort(Comparator.comparingInt(n2 -> n2.weight));

        planets = new int[n];
        for (int i = 0; i < n; i++) planets[i] = i;

        int res = 0;
        int cnt = 0;
        for (Node node : nodes) {
            int x = node.x;
            int y = node.y;
            if (getParent(x) == getParent(y)) continue;
            union(x, y);
            res += node.weight;
            cnt ++;
            if (cnt == n - 1) break;
        }

        System.out.println(res);
    }

    public static int getParent(int x) {
        if(planets[x] == x) return planets[x];
        return planets[x] = getParent(planets[x]);
    }

    public static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        if (x < y) {
            planets[x] = y;
        }
        else {
            planets[y] = x;
        }
    }

    public static class Node {
        int x, y, weight;
        public Node(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
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
            res = res * 10 + mod * (n - 48);
        }
    }
}