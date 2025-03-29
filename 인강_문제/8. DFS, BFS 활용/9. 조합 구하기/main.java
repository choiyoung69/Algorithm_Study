import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public void DFS(int L, int start) {
        if(L == M) {
            for(int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for(int i = start; i <= N; i++){
                arr[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        T.DFS(0 , 1);
    }
}
