import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public int solution(int N, int M, int[][] arr){
        int answer = 0;

        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                boolean flag = true;
                for(int k = 0; k < M; k++){
                    int p1 = 0, p2 = 0;
                    for(int l = 0; l < N; l++){
                        if(arr[k][l] == i) p1 = l;
                        if(arr[k][l] == j) p2 = l;
                    }
                    if(p1 >= p2){
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
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

        int[][] arr = new int[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(main.solution(N, M, arr));
    }
}
