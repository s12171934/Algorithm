
import java.io.*;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys;
    static Queue<Node>[] doors;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int t = 0; t < TC; t++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            h = Integer.parseInt(stringTokenizer.nextToken());
            w = Integer.parseInt(stringTokenizer.nextToken());

            map = new char[h + 2][w + 2];
            visited = new boolean[h + 2][w + 2];
            for(int i = 1; i < h + 1; i++) map[i] = ("." + br.readLine() + ".").toCharArray();

            keys = new boolean[26];
            for(int c : br.readLine().toCharArray()) {
                if(c == 48) break;
                keys[c - 97] = true;
            }

            doors = new Queue[26];
            for(int i = 0; i < 26; i++) doors[i] = new LinkedList<>();

            sb.append(BFS()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int BFS() {
        int res = 0;
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited[node.y][node.x]) continue;
            if(map[node.y][node.x] == '$') res++;
            if(map[node.y][node.x] >= 'a' && map[node.y][node.x] <= 'z') {
                keys[map[node.y][node.x] - 97] = true;
                while (!doors[map[node.y][node.x] - 97].isEmpty()) queue.add(doors[map[node.y][node.x] - 97].poll());
            }
            visited[node.y][node.x] = true;

            for(int i = 0; i < 4; i++) {
                int newY = node.y + y[i];
                int newX = node.x + x[i];
                if(newX < 0 || newY < 0 || newX >= w + 2 || newY >= h + 2) continue;
                if(visited[newY][newX]) continue;
                if(map[newY][newX] == '*') continue;
                if(map[newY][newX] >= 'A' && map[newY][newX] <= 'Z' && !keys[map[newY][newX] - 65]) {
                    doors[map[newY][newX] - 65].add(new Node(newY, newX));
                    continue;
                }
                queue.add(new Node(newY, newX));
            }
        }

        return res;
    }

    public static class Node{
        int x, y;
        public Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}