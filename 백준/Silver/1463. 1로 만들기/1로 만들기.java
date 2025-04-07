import java.util.*;
import java.io.*;

class Main {

    public int solution(int N) {
        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 0;

        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;

            if(i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            }
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }
        }

        return arr[N];
    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(main.solution(N));
    }
}