import java.io.*;
import java.util.*;

public class Main {
    public String solution(String s) {
        String answer = "YES";
		Stack<Character> stack = new Stack<>();
      	for(char ch : s.toCharArray()) {
          	if(ch == '(') stack.push(ch);
          	else if (stack.isEmpty()) {
              	return "NO";
            }
          	else {
              	stack.pop();
            }
        }
      	
      	if(!stack.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(main.solution(s));
    }
}
