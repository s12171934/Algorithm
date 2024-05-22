import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = bufferedReader.readLine();
            
            if (str == null || str.isEmpty()){
                break;
            }
            
            int a = Integer.parseInt(str.split(" ")[0]);
            int b = Integer.parseInt(str.split(" ")[1]);

            System.out.println(a + b);
        }

        bufferedReader.close();
    }
}