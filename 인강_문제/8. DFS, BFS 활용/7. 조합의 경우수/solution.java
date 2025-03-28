import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int[][] dy = new int[35][35];
    public int DFS(int N, int R) {
        if(dy[N][R] > 0) return dy[N][R];
        if(N == R || R == 0) return 1;
        else {
            return dy[N][R] = DFS(N - 1, R - 1) + DFS(N - 1, R);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        System.out.println(T.DFS(N, R));
    }
}
