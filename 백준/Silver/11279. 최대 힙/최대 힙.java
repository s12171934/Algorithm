import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] maxHeap = new int[n + 1];
        int heapSize = 0;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(bufferedReader.readLine());

            if (m == 0) {
                stringBuilder.append(maxHeap[1]).append("\n");
                if (maxHeap[1] == 0) {
                    continue;
                }
                maxHeap[1] = maxHeap[heapSize];
                maxHeap[heapSize] = 0;
                heapSize--;

                int idx = 1;
                while (idx * 2 <= heapSize) {
                    int leftOrRight = idx * 2;
                    if (idx * 2 + 1 <= heapSize && maxHeap[idx * 2] < maxHeap[idx * 2 + 1]) {
                        leftOrRight += 1;
                    }
                    if (maxHeap[idx] < maxHeap[leftOrRight]) {
                        int temp = maxHeap[idx];
                        maxHeap[idx] = maxHeap[leftOrRight];
                        maxHeap[leftOrRight] = temp;
                    }

                    idx = leftOrRight;
                }


            }
            else {
                heapSize++;
                maxHeap[heapSize] = m;
                int idx = heapSize;
                while (idx > 1 && maxHeap[idx/2] < maxHeap[idx]) {
                    int temp = maxHeap[idx];
                    maxHeap[idx] = maxHeap[idx/2];
                    maxHeap[idx/2] = temp;
                    idx /= 2;
                }
            }
        }

        System.out.println(stringBuilder);

        bufferedReader.close();
    }
}