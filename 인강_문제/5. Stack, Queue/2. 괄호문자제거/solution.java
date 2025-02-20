import java.io.*;
import java.util.*;

public class Main {
    public String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
      
      	for(char x : s.toCharArray()) {
          	if(x == ')') {
              	while(stack.pop() != '(');
            }
         	else stack.push(x);
        }
      	for(int i = 0; i < stack.size(); i++) answer += stack.get(i);
             
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(main.solution(s));
    }
}
