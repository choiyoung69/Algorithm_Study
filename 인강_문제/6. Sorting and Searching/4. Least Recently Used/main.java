import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int S, int N, int[] arr) {
        int answer[] = new int[S];

        for(int i = 0; i < S; i++){
            answer[i] = 0;
        }

        for(int i = 0; i < N; i++){
            int idx = -1;
            for(int j = 0; j < S; j++){
                if(answer[j] == arr[i]) idx = j;
            }

            int tmp = 0;
            int pre = answer[0];

            if(idx == -1){
                for(int j = 1; j < S; j++){
                    tmp = answer[j];
                    answer[j] = pre;
                    pre = tmp;
                }
                answer[0] = arr[i];
            }
            else{
                int target = answer[idx];
                for(int j = 1; j <= idx; j++){
                    tmp = answer[j];
                    answer[j] = pre;
                    pre = tmp;
                }
                answer[0] = target;
            }

        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : main.solution(S, N, arr)){
            System.out.print(x + " ");
        }
    }
}
