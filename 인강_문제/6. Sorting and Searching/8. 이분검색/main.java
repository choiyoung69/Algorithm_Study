import java.io.*;
import java.util.*;

public class Main {
    public int solution(int N, int M, int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        int left = 0, right = N - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] < M){
                left = mid + 1;
            }
            else if(arr[mid] > M){
                right = mid - 1;
            }
            else return mid + 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, M, arr));
    }
}
