import java.io.*;
import java.util.*;

public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[4];
        String ans = "NO";
        
        for(int i = 1; i <= N; i++) {
            
            String[] str = br.readLine().split(" ");
            
            switch (str[0]) {
                case "STRAWBERRY":
                    arr[0] += Integer.parseInt(str[1]);
                    break;
                
                case "BANANA":
                    arr[1] += Integer.parseInt(str[1]);
                    break;
                    
                case "LIME":
                    arr[2] += Integer.parseInt(str[1]);
                    break;
                    
                case "PLUM":
                    arr[3] += Integer.parseInt(str[1]);
                    break;
            }
        }
        
        for(int i : arr) {
            if(i == 5) ans = "YES";
        }

        System.out.println(ans);
        
        br.close();
    }
}