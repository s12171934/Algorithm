import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String ans = "";
        int i;
        for(i = 0; i < 8; i++) {
            int start = br.read();
            if (start == 49 + i){
                if (ans.equals("descending")) break;
                ans = "ascending";
            }
            else if (start == 56 - i){
                if (ans.equals("ascending")) break;
                ans = "descending";
            }
            else break;
            br.read();
        }
        if(i != 8) ans = "mixed";

        System.out.println(ans);
        br.close();
    }
}