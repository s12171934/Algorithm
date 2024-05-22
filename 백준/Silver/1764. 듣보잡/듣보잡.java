import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        Set<String> noListen = new HashSet<>();
        Set<String> noSee = new HashSet<>();

        for (int i = 0; i < n; i++) {
            noListen.add(bufferedReader.readLine());
        }

        for (int i = 0; i < m; i++) {
            noSee.add(bufferedReader.readLine());
        }

        noSee.retainAll(noListen);
        stringBuilder.append(noSee.size()).append("\n");
        for (Object s : noSee.stream().sorted().toArray()) {
            stringBuilder.append(s).append("\n");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}