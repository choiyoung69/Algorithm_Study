import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public void solution(int N, int[] arr) {
        int[] intArr = new int[N];
        StringBuilder sb;
        int max = Integer.MIN_VALUE;

        //숫자 뒤집기
        for (int i = 0; i < N; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp/10;
            }
            intArr[i] = res;
            if(max < res) max = res;
        }

        boolean[] decimal = new boolean[max + 1];
        decimal[1] = true;

        for(int i = 2; i * i <= max; i++) {
            if(!decimal[i]) { //소수면
                for (int j = i * i; j <= max; j += i) {
                    decimal[j] = true;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            if(!decimal[intArr[i]]) System.out.print(intArr[i] + " ");
        }

    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        main.solution(N, arr);
    }
}
