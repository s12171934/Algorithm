import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        PriorityQueue<Integer> bags = new PriorityQueue<>();
        PriorityQueue<Jewel> priorityQueue = new PriorityQueue<>();
        int N = read();
        int K = read();
        long res = 0;
        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) jewels.add(new Jewel(read(), read()));
        jewels.sort((j1, j2) -> {
            if (j1.M == j2.M) return j2.V - j1.V;
            return j1.M - j2.M;
        });
        for (int i = 0; i < K; i++) bags.add(read());
        int j = 0;
        while (!bags.isEmpty()) {
            int bag = bags.poll();
            while (j < N) {
                if (jewels.get(j).M > bag) break;
                priorityQueue.add(jewels.get(j++));
            }

            if(!priorityQueue.isEmpty()) res += priorityQueue.poll().V;
        }
        System.out.println(res);
        bufferedReader.close();
    }

    public static class Jewel implements Comparable<Jewel>{
        int M, V;
        public Jewel (int M, int V) {
            this.M = M;
            this.V = V;
        }

        @Override
        public int compareTo(Jewel o) {
            return o.V - this.V;
        }
    }

    public static int read() throws Exception {
        int res = 0;
        while (true) {
            int n = bufferedReader.read();
            if (n == 10 || n == 32) return res;
            res = res * 10 + n - 48;
        }
    }
}