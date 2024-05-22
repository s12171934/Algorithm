import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = bufferedReader.readLine();
        }

        bufferedReader.close();

        for(Object s : Arrays.stream(str).distinct().sorted(Main::comparator).toArray()){
            System.out.println(s);
        }
    }

    static int comparator(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2);
        }
        else {
            return s1.length() > s2.length() ? 1 : -1;
        }
    }
}