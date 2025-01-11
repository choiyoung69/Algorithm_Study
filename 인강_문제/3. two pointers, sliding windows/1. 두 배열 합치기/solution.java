import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public List<Long> solution(int N, int M, long[] n_arr, long[] m_arr){
        List<Long> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < N && p2 < M){
            if(n_arr[p1] < m_arr[p2]) answer.add(n_arr[p1++]);
            else answer.add(m_arr[p2++]);
        }

        while(p1<N) {
            answer.add(n_arr[p1++]);
        }
        while(p2<M){
            answer.add(m_arr[p2++]);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] NArr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NArr[i] = Long.parseLong(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        long[] MArr = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            MArr[i] = Long.parseLong(st.nextToken());
        }

        for(long x : main.solution(N, M, NArr, MArr)) System.out.print(x + " ");
    }
}
