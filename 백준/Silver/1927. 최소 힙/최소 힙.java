import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] minHeap = new int[n + 1];
        int heapSize = 0;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(bufferedReader.readLine());

            if (m == 0) {
                stringBuilder.append(minHeap[1]).append("\n");
                if (minHeap[1] == 0) {
                    continue;
                }
                minHeap[1] = minHeap[heapSize];
                minHeap[heapSize] = 0;
                heapSize--;

                int idx = 1;
                while (idx * 2 <= heapSize) {
                    int leftOrRight = idx * 2;
                    if (idx * 2 + 1 <= heapSize && minHeap[idx * 2] > minHeap[idx * 2 + 1]) {
                        leftOrRight += 1;
                    }
                    if (minHeap[idx] > minHeap[leftOrRight]) {
                        int temp = minHeap[idx];
                        minHeap[idx] = minHeap[leftOrRight];
                        minHeap[leftOrRight] = temp;
                    }

                    idx = leftOrRight;
                }


            }
            else {
                heapSize++;
                minHeap[heapSize] = m;
                int idx = heapSize;
                while (idx > 1 && minHeap[idx/2] > minHeap[idx]) {
                    int temp = minHeap[idx];
                    minHeap[idx] = minHeap[idx/2];
                    minHeap[idx/2] = temp;
                    idx /= 2;
                }
            }
        }

        System.out.println(stringBuilder);

        bufferedReader.close();
    }
}