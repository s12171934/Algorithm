import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();


        int n = Integer.parseInt(bufferedReader.readLine());
        int[] answer = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            answer[i] = num;
        }

        int[] sort = Arrays.stream(answer).distinct().sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sort.length; i++) {
            map.put(sort[i],i);
        }


        for (int i = 0; i < n; i++) {
            stringBuilder.append(map.get(answer[i])).append(" ");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}