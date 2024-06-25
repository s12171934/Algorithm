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

            for(int i = e.length - 1; i >= s.length; i--) {
                if(e[i] == 'Y') {
                    Stack<Character> stack = new Stack<>();
                    for(int j = 0; j < i; j++) {
                        stack.push(e[j]);
                    }
                    for(int j = 0; j < i; j++) {
                        e[j] = stack.pop();
                    }
                }
            }

            String res = "Yes";
            for(int i = 0; i < s.length; i++) {
                if(s[i] != e[i]) {
                    res = "No";
                    break;
                }
            }

            System.out.println("#" + test_case + " " + res);
        }
    }
}