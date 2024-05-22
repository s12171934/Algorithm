import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] str = bufferedReader.readLine().split(" ");

            switch (str[0]) {
                case "push" :
                    stack.push(str[1]);
                    break;

                case "pop" :
                    stringBuilder.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;

                case "size" :
                    stringBuilder.append(stack.size()).append("\n");
                    break;

                case "empty" :
                    stringBuilder.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "top" :
                    stringBuilder.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
            }

        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}