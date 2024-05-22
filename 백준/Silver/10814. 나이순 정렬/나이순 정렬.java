import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = bufferedReader.readLine();
        }

        bufferedReader.close();

        for(Object s : Arrays.stream(str).sorted(Main::compare).toArray()){
            stringBuilder.append(s).append("\n");
        }

        System.out.println(stringBuilder);
    }

    static int compare(String s1, String s2) {
        int age1 = Integer.parseInt(s1.split(" ")[0]);
        int age2 = Integer.parseInt(s2.split(" ")[0]);

        return age1 - age2;
    }
}