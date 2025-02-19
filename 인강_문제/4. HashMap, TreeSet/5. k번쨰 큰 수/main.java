import java.io.*;
import java.util.*;

public class Main {
    public int solution(int N, int K, int[] arr) {
        int answer = 0;
        Set<Integer> s = new TreeSet<>(Comparator.reverseOrder());
        int sum = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    s.add(sum);
                }
            }
        }

        Iterator<Integer> it = s.iterator();
        if(s.size() < K) {
            answer = -1;
        }
        else{
            for(int i = 0; i < K; i++){
                answer = it.next();
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution(N, K, arr));
    }
}
