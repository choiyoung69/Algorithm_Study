import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int solution(int N){
        int answer = 0, lt = 0, sum = 0;
        int m = N/2 + 1;
        int[] arr = new int[m];
        for(int i = 1; i <= m; i++){
            arr[i - 1] = i;
        }

        for(int rt = 0; rt < m; rt++){
            sum += arr[rt];
            if(sum == N) answer++;
            while(sum >= N){
                sum -= arr[lt++];
                if(sum == N) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(main.solution(N));
    }
}
