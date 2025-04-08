import java.util.*;
import java.io.*;

class Main {
    public int solution(int N) {
        int[] arr = new int[N + 2];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;

        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 2] * 2 + arr[i - 1]) % 10007;
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