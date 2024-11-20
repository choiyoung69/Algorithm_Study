import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static final int CLASS_SIZE = 5;

    public int solution(int N, int[][] arr){
        int answer = 0;
        int maxSharedClasses = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                for(int k = 0; k < CLASS_SIZE; k++){
                    if (arr[i][k]  == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > maxSharedClasses) {
                maxSharedClasses = cnt;
                answer = i + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][CLASS_SIZE];

        for(int i = 0; i < N; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j = 0; j < CLASS_SIZE; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        System.out.println(main.solution(N, arr));
    }
}
