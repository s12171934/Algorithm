import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder res = new StringBuilder();

    static class Trie {
        boolean leaf;
        Trie[] child = new Trie[26];
    }
    
    public static void main(String[] args) throws Exception {
        init();
        for (String word : words) {
             solve(word, false, 0);   
        }
        System.out.println(res.toString());
    }

    static List<String> words;
    static Trie root;

    static void init() throws Exception {
        words = new ArrayList<>();
        root = new Trie();
        
        String line;
        while ((line = br.readLine()) != null) {
            words.add(line);
        }

        for (String word : words) {
            initTrie(word);
        }
    }

    static void initTrie(String word) {
        char[] charArr = word.toCharArray();

        Trie cur = root;
        for (char c : charArr) {
            if (cur.child[c - 'a'] == null) {
                cur.child[c - 'a'] = new Trie();
            }
            cur = cur.child[c - 'a'];
        }
        cur.leaf = true;
    }

    static boolean solve(String word, boolean second, int index) {
        char[] charArr = word.toCharArray();

        if (index == charArr.length) {
            return false;
        }

        Trie cur = root;
        for (int i = index; i < charArr.length; i++) {
            cur = cur.child[charArr[i] - 'a'];
            if (cur == null) {
                return false;
            }

            if (cur.leaf && !second) {
                if(solve(word, true, i + 1)) {
                    break;    
                }
            }
        }

        if(cur.leaf && second) {
            res.append(word).append("\n");
            return true;
        }

        return false;
    }
}