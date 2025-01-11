import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int solution(int N, int K, int[] arr){
        int answer = 0;
        int[] temp = new int[N - K + 1];

        int tmp = 0;
        for(int i = 0; i < N - K + 1; i++){
            tmp = 0;
            for(int j = 0; j < K; j++){
                tmp += arr[i + j];
            }
            temp[i] = tmp;
        }

        Arrays.sort(temp);
        answer = temp[N - K];

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, K, arr));
    }
}
