import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public List<Long> solution(int N, int M, long[] n_arr, long[] m_arr){
        List<Long> answer = new ArrayList<>();

        List<Long> NArr = new ArrayList<>(Arrays.stream(n_arr)
                .boxed()
                .collect(Collectors.toList()));
        Collections.sort(NArr);

        List<Long> MArr = new ArrayList<>(Arrays.stream(m_arr)
                .boxed()
                .collect(Collectors.toList()));
        Collections.sort(MArr);

        int a = 0, b = 0;

        for(int i = 0; i < N + M; i++){
            if(NArr.get(a) > MArr.get(b)){
                b++;
            }
            else if(NArr.get(a) < MArr.get(b)){
                a++;
            }
            else{
                answer.add(NArr.get(a));
                b++;
            }

            if(a == N || b == M) break;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] n_arr = new long[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            n_arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        long[] m_arr = new long[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            m_arr[i] = Integer.parseInt(st.nextToken());
        }

        for(long i : main.solution(N, M, n_arr, m_arr)){
            System.out.print(i + " ");
        }
    }
}
