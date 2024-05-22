import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] deque = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            String[] str = bufferedReader.readLine().split(" ");

            switch (str[0]) {
                case "push_front" :
                    for (int j = size - 1; j >= 0; j--) {
                        deque[j + 1] = deque[j];
                    }
                    deque[0] = Integer.parseInt(str[1]);
                    size++;
                    break;

                case "push_back" :
                    deque[size] = Integer.parseInt(str[1]);
                    size++;
                    break;

                case "pop_front" :
                    stringBuilder.append(deque[0] == 0 ? -1 : deque[0]).append("\n");
                    if (deque[0] == 0) break;

                    for (int j = 0; j < size - 1; j++) {
                        deque[j] = deque[j + 1];
                    }
                    deque[size - 1] = 0;
                    size--;
                    break;

                case "pop_back" :
                    stringBuilder.append(deque[0] == 0 ? -1 : deque[size - 1]).append("\n");
                    if (deque[0] == 0) break;

                    deque[size - 1] = 0;
                    size--;
                    break;

                case "size" :
                    stringBuilder.append(size).append("\n");
                    break;

                case "empty" :
                    stringBuilder.append(deque[0] == 0 ? 1 : 0).append("\n");
                    break;

                case "front" :
                    stringBuilder.append(deque[0] == 0 ? -1 : deque[0]).append("\n");
                    break;

                case "back" :
                    stringBuilder.append(deque[0] == 0 ? -1 : deque[size - 1]).append("\n");
                    break;
            }

        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}