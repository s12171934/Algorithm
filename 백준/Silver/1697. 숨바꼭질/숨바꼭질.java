import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[] arr = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        arr[n] = 1;
        queue.add(n);

        while (n != m && arr[m] == 0) {
             while (arr[queue.peek()] == count) {
                 int i = queue.poll();
                 if (i - 1 >= 0 && arr[i - 1] == 0) {
                     arr[i - 1] = count + 1;
                     queue.add(i - 1);
                 }
                 if (i + 1 < 100001 && arr[i + 1] == 0) {
                     arr[i + 1] = count + 1;
                     queue.add(i + 1);
                 }
                 if (i * 2 < 100001 && arr[i * 2] == 0) {
                     arr[i * 2] = count + 1;
                     queue.add(i * 2);
                 }
            }
            count++;
        }

        System.out.println(arr[m] - 1);

        bufferedReader.close();
    }
}