import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String solution(int N, int[] a, int[] b){
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < N; i++){
            if(a[i] == b[i]) answer.append("D\n");
            else if(a[i] == 1 && b[i] == 3) answer.append("A\n");
            else if(a[i] == 2 && b[i] == 1) answer.append("A\n");
            else if(a[i] == 3 && b[i] == 2) answer.append("A\n");
            else answer.append("B\n");
        }

        return answer.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A_arr = new int[N];
        for(int i = 0; i < N; i++){
            A_arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] B_arr = new int[N];
        for(int i = 0; i < N; i++){
            B_arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, A_arr, B_arr));
    }
}
