import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String ans = "NO...";

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        int start = Integer.parseInt(str[0]);
        int dist = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        int y = Integer.parseInt(str[0]);
        int x = Integer.parseInt(str[1]);

        if (y == 1 && ( (dist == 0 && start < x) || (dist == 1 && start > x) )) ans = "YES!";
        if (y == N && N % 2 != dist) ans = "YES!";

        System.out.println(ans);

        br.close();
    }
}