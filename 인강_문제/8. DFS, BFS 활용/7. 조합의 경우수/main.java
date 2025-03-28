import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int DFS(int N, int R) {
        if(N == R) return 1;
        if(R == 1){
            return N;
        } else {
            return DFS(N - 1, R - 1) + DFS(N - 1, R);
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
