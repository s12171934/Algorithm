import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] str = bufferedReader.readLine().split(" ");

            switch (str[0]) {
                case "add" :
                    set.add(str[1]);
                    break;

                case "remove" :
                    set.remove(str[1]);
                    break;

                case "check" :
                    stringBuilder.append(set.contains(str[1]) ? 1 : 0).append("\n");
                    break;

                case "toggle" :
                    if (set.contains(str[1])) {
                        set.remove(str[1]);
                    }
                    else {
                        set.add(str[1]);
                    }
                    break;

                case "all" :
                    set = new HashSet<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"));
                    break;

                case "empty" :
                    set = new HashSet<>();
                    break;
            }
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}