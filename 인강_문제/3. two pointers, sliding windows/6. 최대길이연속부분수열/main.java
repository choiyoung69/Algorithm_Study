import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int solution(int N, int k, int[] arr){
        int answer = 0, cnt = 0, lt = 0;

        for(int rt = 0; rt < N; rt++){
            if(arr[rt] == 0) k--;

            while(k < 0){
                if(arr[lt] == 0) k++;
                lt++;
                cnt--;
            }

            cnt++;

            if(cnt > answer) answer = cnt;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, k, arr));
    }
}
