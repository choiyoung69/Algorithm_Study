import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int N, M;

    public void DFS(int TS, int TC, int L, int[] score, int[] time) {
        if(TC > M) return;
        if(L == N) {
            answer = Math.max(answer, TS);
        }
        else {
            DFS(TS + score[L], TC + time[L], L + 1, score, time);
            DFS(TS, TC, L + 1, score, time);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] score = new int[N];
        int[] time = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            score[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }

        T.DFS(0, 0, 0, score, time);
        System.out.println(answer);
    }
}
