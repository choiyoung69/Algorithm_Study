import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int N, int M, int[] n_arr, int[] m_arr){
        int[] answer = new int[N + M];

        int a = 0, b = 0;

        for (int i = 0; i < answer.length; i++) {
            if(n_arr[a] <= m_arr[b]) {
                answer[i] = n_arr[a];
                a++;
            }
            else if(n_arr[a] > m_arr[b]){
                answer[i] = m_arr[b];
                b++;
            }

            if(a == N || b == M){
                break;
            }
        }

        if(a == N){
            for(int i = b; i < M; i++){
                answer[a + i] = m_arr[i];
            }
        }
        else if(b == M){
            for(int i = a; i < N; i++){
                answer[b + i] = n_arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //N 배열
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] n_arr = new int[N];

        for (int i = 0; i < N; i++) {
            n_arr[i] = Integer.parseInt(st.nextToken());
        }

        //M 배열
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] m_arr = new int[M];

        for (int i = 0; i < M; i++) {
            m_arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : main.solution(N, M, n_arr, m_arr)){
            System.out.print(i + " ");
        }

    }
}
