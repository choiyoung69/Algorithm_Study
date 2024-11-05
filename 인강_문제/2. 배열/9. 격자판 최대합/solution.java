import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int N, int[][] arr){
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;

        for(int i = 0; i < N; i++){
            sum1 = sum2 = 0;
            for(int j = 0; j < N; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = sum2 = 0;
        for(int i = 0; i < N; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][N - 1 - i];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        System.out.println(main.solution(N, arr));
    }
}
