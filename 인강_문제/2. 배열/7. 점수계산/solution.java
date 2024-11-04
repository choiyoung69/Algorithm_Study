import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public int solution(int N, int[] arr){
        int answer = 0, cnt = 0;

        for(int i = 0; i < N; i++){
            if(arr[i] == 1){
                cnt++;
                answer += cnt;
            }
            else{
                cnt = 0;
            }
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

        System.out.println(main.solution(N, arr));
    }
}
