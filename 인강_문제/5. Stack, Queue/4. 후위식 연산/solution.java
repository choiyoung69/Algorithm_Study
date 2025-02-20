import java.io.*;
import java.util.*;

public class Main {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
		for(char x : str.toCharArray()) {
          	if(Character.isDigit(x)) stack.push(Integer.parseInt(String.valueOf(x)));
          	else {
              	int a = stack.pop();
              	int b = stack.pop();
              	if(x == '+') stack.push(a + b);
              	else if(x == '-') stack.push(b - a);
              	else if(x == '*') stack.push(a*b);
              	else if(x == '/') stack.push(b/a);
            }
        }
      	answer = stack.pop();

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(main.solution(str));
    }
}
