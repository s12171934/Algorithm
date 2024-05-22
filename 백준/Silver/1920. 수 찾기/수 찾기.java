import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        
        int m = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        
        for (int i = 0; i < m; i++) {
            if (set.contains(Integer.parseInt(stringTokenizer.nextToken()))) {
                stringBuilder.append("1\n");
            }
            else {
                stringBuilder.append("0\n");
            }
        }
        System.out.println(stringBuilder);
    }
}