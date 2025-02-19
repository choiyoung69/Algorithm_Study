import java.io.*;
import java.util.*;

public class Main {
    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack();

        for (char ch : str.toCharArray()) {
            if(Character.isDigit(ch)) {
                stack.push(Integer.parseInt(String.valueOf(ch)));
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                int temp;

                if(ch == '+') temp = a + b;
                else if(ch == '-') temp = b - a;
                else if(ch == '*') temp = a * b;
                else temp = b / a;

                stack.push(temp);
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
