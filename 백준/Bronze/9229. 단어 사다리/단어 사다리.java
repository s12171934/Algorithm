import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		String before = br.readLine();
		end: while(true) {
			next: while(true) {
				String cur = br.readLine();
				if(cur.equals("#")) {
					res.append("Correct\n");
					before = br.readLine();
					if(before.equals("#")) break end;
					break next;
				}
				else {
					boolean check = false;
					if (cur.length() != before.length()) {
						while(!br.readLine().equals("#")) {}
						res.append("Incorrect\n");
						before = br.readLine();
						if(before.equals("#")) break end;
						break next;
					}
					for(int i = 0; i < before.length(); i++) {
						if(before.charAt(i) == cur.charAt(i)) continue;
						if (check) {
							while(!br.readLine().equals("#")) {}
							res.append("Incorrect\n");
							before = br.readLine();
							if(before.equals("#")) break end;
							break next;
						}
						check = true;
					}
					if (!check) {
						while(!br.readLine().equals("#")) {}
						res.append("Incorrect\n");
						before = br.readLine();
						if(before.equals("#")) break end;
						break next;
					}
					before = cur;
				}
			}
		}
		
		System.out.println(res.toString());
 	}
}
