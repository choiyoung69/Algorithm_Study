import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    public void solution(int N) {
        if(N < 0) return;
        if (N == 0) {
            answer++;
        }
        else {
            solution(N-1);
            solution(N-2);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        T.solution(N);
        System.out.println(answer);
    }
}
