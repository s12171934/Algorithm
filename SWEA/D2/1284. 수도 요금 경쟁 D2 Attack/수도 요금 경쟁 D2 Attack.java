import java.util.*;
import java.util.stream.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++) {
            int[] l = IntStream.range(0,5).map(i -> sc.nextInt()).toArray();
            System.out.println("#" + t + " " + Math.min(l[0] * l[4], l[1] + Math.max(0, l[4] - l[2]) * l[3]));
        }
    }
}