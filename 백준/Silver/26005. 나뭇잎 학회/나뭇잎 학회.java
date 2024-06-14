import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(n == 1 ? 0 : (int) Math.ceil(n * n / (double) 2));
        br.close();
    }
}