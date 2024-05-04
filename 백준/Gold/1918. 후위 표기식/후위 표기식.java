import java.io.*;
import java.util.Stack;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[] inOrder = br.readLine().toCharArray();
        Stack<Character> symbols = new Stack<>();

        for(char c : inOrder) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
                continue;
            }
            //연산자 스택 처리
            if (!symbols.empty()) {
                if (c == '+' || c == '-') {
                    while (!symbols.empty() && symbols.peek() != '(') {
                        sb.append(symbols.pop());
                    }
                }
                else if (c == '*' || c == '/') {
                    if (!symbols.empty() && (symbols.peek() == '*' || symbols.peek() == '/')) {
                        sb.append(symbols.pop());
                    }
                }
                else if (c == ')') {
                    while (true) {
                        char symbol = symbols.pop();
                        if (symbol == '(') break;
                        sb.append(symbol);
                    }
                    continue;
                }
            }
            symbols.push(c);
        }

        while (!symbols.empty()) {
            sb.append(symbols.pop());
        }

        System.out.println(sb);
        br.close();
    }
}