import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int solution(int N){
        int answer = 0, cnt = 1;
        N--;
        while(N > 0){
            cnt++;
            N -= cnt;

            if(N % cnt == 0) answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(main.solution(N));
    }
}
