import java.io.*;
import java.util.*;

public class Main {
    public String solution(String order, String design) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();

        for (char ch : order.toCharArray()) {
            q.add(ch);
        }

        for (char ch : design.toCharArray()) {
            if(q.isEmpty()) break;
            if(q.peek() == ch) q.poll();
        }

        if (!q.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        String design = br.readLine();

        System.out.println(main.solution(order, design));
    }
}
