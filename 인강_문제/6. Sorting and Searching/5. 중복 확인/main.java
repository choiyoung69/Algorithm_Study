import java.io.*;
import java.util.*;

public class Main {
    public char solution(int N, int[] arr) {
        char answer = 'U';

        Arrays.sort(arr);
        for(int i = 0; i < N - 1; i++){
            if(arr[i] == arr[i + 1]) return 'D';
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

        System.out.println(main.solution(N, arr));
    }
}
