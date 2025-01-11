import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int solution(int N, int M, int[] arr){
        int answer = 0;

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum = 0;
            for(int j = 0; j < N - i; j++){
                sum += arr[i + j];
                if(sum > M) break;
                if(sum == M){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, M, arr));
    }
}
