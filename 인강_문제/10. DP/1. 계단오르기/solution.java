import java.io.*;
import java.util.*;

public class Main {
    static int[] dy;

    public int solution(int N) {
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= N; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        return dy[N];
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dy = new int[N + 1];

        System.out.println(T.solution(N));
    }
}
