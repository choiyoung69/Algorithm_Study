import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public int[] solution(int N, int[] arr){
        int[] answer = new int[N];

        for(int i = 0; i < N; i++){
            int cnt = 1;
            for(int j = 0; j < N; j++){
                if(arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int x : main.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }
}
