import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        Map<String, Integer> name_id = new HashMap<>();
        Map<Integer, String> id_name = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = bufferedReader.readLine();
            name_id.put(name, i);
            id_name.put(i,name);
        }

        for (int i = 0; i < m; i++) {
            String quiz = bufferedReader.readLine();
            try {
                stringBuilder.append(id_name.get(Integer.parseInt(quiz))).append("\n");
            }
            catch (NumberFormatException e) {
                stringBuilder.append(name_id.get(quiz)).append("\n");
            }
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}