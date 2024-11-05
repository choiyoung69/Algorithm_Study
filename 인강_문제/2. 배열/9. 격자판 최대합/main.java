import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int N, int[][] arr){
        int answer = -1;

        // 각 행의 합 비교
        for(int i = 0; i < N; i++){
            int tmp = 0;
            for(int j = 0; j < N; j++){
                tmp += arr[i][j];
            }
            if(tmp > answer) answer = tmp;
        }

        // 각 열의 합 비교
        for(int i = 0; i < N; i++){
            int tmp = 0;
            for(int j = 0; j < N; j++){
                tmp += arr[j][i];
            }
            if(tmp > answer) answer = tmp;
        }

        // 대각선의 합 비교
        int tmp = 0;
        for(int i = 0; i < N; i++){
            tmp += arr[i][i];
        }
        if(tmp > answer) answer = tmp;

        // 대각선의 합 비교
        tmp = 0;
        for(int i = 0; i < N; i++){
            tmp += arr[i][N - i - 1];
        }
        if(tmp > answer) answer = tmp;

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
