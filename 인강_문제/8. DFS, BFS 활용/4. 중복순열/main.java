import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] answer;

    public void DFS(int L) {
        if(L == M){
            for(int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for(int i = 1; i <= N; i++) {
                answer[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];

        T.DFS(0);
    }
}
