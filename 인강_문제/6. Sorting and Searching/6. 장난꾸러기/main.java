import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int N, int[] arr) {
        int[] answer = new int[2];
        int[] tmp = arr.clone();
        Arrays.sort(arr);

        int cnt = 0;
        for(int i = 0; i < N; i++){
            if(tmp[i] != arr[i]) {
                answer[cnt] = i + 1;
                cnt++;
            }
            if(cnt == 2) break;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int x : main.solution(N, arr)){
            System.out.print(x + " ");
        }
    }
}
