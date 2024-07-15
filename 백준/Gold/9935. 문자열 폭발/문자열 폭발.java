import java.util.*;
import java.io.*;

public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static ArrayList<Integer> preOrder;
	
	public static void main(String[] args) throws IOException {
		
		char[] arr = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			stack.add(arr[i]);
			
			if(stack.peek() == bomb[bomb.length -1]) {
				boolean check = true;
				for (int j = 0; j < bomb.length; j++) {
					if(stack.size() >= bomb.length && bomb[j] != stack.get(stack.size() - bomb.length + j)) {
						check = false;
						break;
					}
				}
				if (stack.size() >= bomb.length && check) {
					for (int j = 0; j < bomb.length; j++) stack.pop();
				}
			}
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		
		for (Character c : stack) {
			sb.append(c);
		}
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
}