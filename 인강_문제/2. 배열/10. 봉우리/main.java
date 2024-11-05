import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int solution(int N, int[][] arr){
        int answer = 0;

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if((arr[i][j] > arr[i - 1][j]) && (arr[i][j] > arr[i + 1][j]) &&
                        (arr[i][j] > arr[i][j + 1]) && (arr[i][j] > arr[i][j - 1])){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 2][N + 2];

        for(int i = 1; i < N + 1; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        System.out.println(main.solution(N, arr));
    }
}
