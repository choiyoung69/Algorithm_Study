import java.io.*;
import java.util.Arrays;

class Main {

    public void solution(int N, int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[][] temp = new int[max + 1][3];

        if(max >0) {
            temp[1][0] = 1;
        }
        if(max > 1) {
            temp[2][1] = 1;
        }
        if(max > 2) {
            temp[3][0] = 1;
            temp[3][1] = 1;
            temp[3][2] = 1;
        }

        for(int i = 4; i <= max; i++) {
            for (int j = 3; j >= 1; j--) {
                int sum = 0;
                for(int k = 0; k < 3; k++) {
                    if(k+1 == j) continue;
                    sum = (sum + temp[i - j][k]) % 1000000009;
                }
                temp[i][j - 1] = sum;
            }
        }

        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = 0; j < 3; j++){
                sum = (sum + temp[arr[i]][j]) % 1000000009;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        main.solution(N, arr);
    }
}