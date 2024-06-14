import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int length = 1;
        int num = 0;

        while (true) {
            int read = br.read();
            if (read < 48) break;
            if (num == 0) num = read;
            else {
                if(num != read) {
                    num = read;
                    length++;
                }
            }
        }

        System.out.println(length / 2);

        br.close();
    }
}