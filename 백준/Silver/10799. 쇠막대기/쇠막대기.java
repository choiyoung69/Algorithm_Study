import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stk = new Stack<>();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stk.push(ch);
            } else {
                stk.pop();
                
                if (str.charAt(i - 1) == '(') {
                    count += stk.size();
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

