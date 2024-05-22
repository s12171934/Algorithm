import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, String[]> node = new HashMap<>();
    static String preorder = "";
    static String inorder = "";
    static String postorder = "";
    public static void main(String[] args) throws Exception {
        int N = read();
        for (int i = 0; i < N; i++) {
            String[] str = bufferedReader.readLine().split(" ");
            node.put(str[0], new String[]{str[1], str[2]});
        }
        setPreorder("A");
        setInorder("A");
        setPostorder("A");

        System.out.println(preorder);
        System.out.println(inorder);
        System.out.println(postorder);
        bufferedReader.close();
    }

    static void setPreorder (String root) {
        String left = node.get(root)[0];
        String right = node.get(root)[1];

        preorder += root;
        if(!left.equals(".")) setPreorder(left);
        if(!right.equals(".")) setPreorder(right);
    }

    static void setInorder (String root) {
        String left = node.get(root)[0];
        String right = node.get(root)[1];

        if(!left.equals(".")) setInorder(left);
        inorder += root;
        if(!right.equals(".")) setInorder(right);
    }

    static void setPostorder (String root) {
        String left = node.get(root)[0];
        String right = node.get(root)[1];

        if(!left.equals(".")) setPostorder(left);
        if(!right.equals(".")) setPostorder(right);
        postorder += root;
    }

    static int read() throws Exception {
        int res = 0;
        while (true) {
            int pointer = bufferedReader.read();
            if (pointer == 32 || pointer == 10) {
                return res;
            }
            res = 10 * res + pointer - 48;
        }
    }
}