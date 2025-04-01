import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main { ;
    public int solution(int N, int[][] arr) {
        int total = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                total++;
                flag = false;
            }
        }
        return N - total;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, arr));
    }
}
