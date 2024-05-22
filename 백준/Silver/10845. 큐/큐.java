import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] queue = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            String[] str = bufferedReader.readLine().split(" ");

            switch (str[0]) {
                case "push" :
                    queue[size] = Integer.parseInt(str[1]);
                    size++;
                    break;

                case "pop" :
                    stringBuilder.append(queue[0] == 0 ? -1 : queue[0]).append("\n");
                    if (queue[0] == 0) break;

                    for (int j = 0; j < size - 1; j++) {
                        queue[j] = queue[j + 1];
                    }
                    queue[size - 1] = 0;
                    size--;
                    break;

                case "size" :
                    stringBuilder.append(size).append("\n");
                    break;

                case "empty" :
                    stringBuilder.append(queue[0] == 0 ? 1 : 0).append("\n");
                    break;

                case "front" :
                    stringBuilder.append(queue[0] == 0 ? -1 : queue[0]).append("\n");
                    break;

                case "back" :
                    stringBuilder.append(queue[0] == 0 ? -1 : queue[size - 1]).append("\n");
                    break;
            }

        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}