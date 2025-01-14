import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int solution(int N){
        int answer = 0;
        int sum = 0, k = 0;
        for(int i = 1; i <= N/2; i++){
            sum = i;
            k = i + 1;
            while(sum < N){
                sum += k;
                k++;
            }
            if(sum == N) answer++;
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
