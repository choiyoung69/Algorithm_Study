import java.io.*;
import java.util.*;

public class Main {
    public String solution(String order, String design) {
        String answer = "YES";
        Queue<Character> q = new LinkedList<>();
        for(char x : order.toCharArray()) q.add(x);
        for(char x: design.toCharArray()){
            if(q.contains(x)){
                if(x!=q.poll()) return "NO";
            }
        }
        if(!q.isEmpty()) return "NO";
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
