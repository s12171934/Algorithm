import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();

        int len = 1;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if(i != 0 && s[i] != s[i - 1]) len++;
            else {
                ans += Math.max(0,(len - 1) / 2 + 1 - n);
                if(s[i] == 'I') len = 1;
                else len = 0;
            }
        }
        ans += Math.max(0,(len - 1) / 2 + 1 - n);

        System.out.println(ans);
    }
}