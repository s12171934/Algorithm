import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            char[] s = sc.next().toCharArray();
            char[] e = sc.next().toCharArray();
            boolean res = false;

            Queue<char[]> q = new LinkedList<>();
            q.offer(e);

            while (!q.isEmpty()) {
                char[] target = q.poll();

                if(target.length == s.length) {
                    res = true;
                    for(int i = 0; i < s.length; i++) {
                        if(s[i] != target[i]) {
                            res = false;
                            break;
                        }
                    }
                    if(res) break;
                    else continue;
                }

                if(target[target.length-1] == 'X') {
                    char[] newTarget = new char[target.length - 1];
                    for(int i = 0; i < newTarget.length; i++) {
                        newTarget[i] = target[i];
                    }
                    q.offer(newTarget);
                }

                if(target[0] == 'Y') {
                    char[] newTarget = new char[target.length - 1];
                    for(int i = 0; i < newTarget.length; i++) {
                        newTarget[i] = target[target.length - 1 - i];
                    }
                    q.offer(newTarget);
                }
            }
            
            System.out.println("#" + test_case + " " + (res ? "Yes" : "No") );
        }
    }
}