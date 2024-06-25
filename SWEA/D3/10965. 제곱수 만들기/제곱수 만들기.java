import java.util.*;

class Solution
{
    public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
         StringBuilder sb = new StringBuilder();
         int TC = sc.nextInt();
         int[] primeArr = new int[10000001];
         boolean[] check = new boolean[10000001];
         Arrays.fill(primeArr, 1);
         for(int i = 2; i <= 10000000; i++) {
             if(check[i]) continue;
             check[i] = true;
             int count = 1;
             while (count * i <= 10000000) {
                 check[count * i] = true;
                 int temp = count;
                 int tempCount = 1;
                 while (temp % i == 0) {
                     temp /= i;
                     tempCount++;
                 }
                 if(tempCount % 2 == 1) primeArr[count * i] *= i;
                 count++;
             }
         }

         for (int tc = 0; tc < TC; tc++) {
             sb.append("#").append(tc + 1).append(" ").append(primeArr[sc.nextInt()]).append("\n");
         }
         System.out.println(sb);
    }
}