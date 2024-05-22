import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        bufferedReader.close();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int times = 1;

        while (true) {
            int target = queue.poll();
            if (times % k == 0) {
                 stringBuilder.append(target);
                 if (queue.isEmpty()) {
                     stringBuilder.append(">");
                     break;
                 }
                 else {
                     stringBuilder.append(", ");
                 }
            }
            else {
                queue.add(target);
            }
            times++;
        }

        System.out.println(stringBuilder);
    }
}