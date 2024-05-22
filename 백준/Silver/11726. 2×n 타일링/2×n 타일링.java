import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        arr = new int[n];
        System.out.println(tile(n));
        bufferedReader.close();
    }

    static int tile(int n) {
        if(arr[n -1] == 0){
            if (n == 1) {
               arr[0] = 1;
               return 1;
            }

            if (n == 2) {
                arr[1] = 2;
                return 2;
            }
            arr[n - 1] = (tile(n - 2) + tile(n - 1)) % 10007;
            return  arr[n -1];
        }

        return arr[n -1];
    }
}