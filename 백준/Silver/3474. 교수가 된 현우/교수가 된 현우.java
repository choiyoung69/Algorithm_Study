import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = 1;
            int temp = Integer.parseInt(br.readLine());
            while (Math.pow(5, k) <= temp) {
                k++;
            }
            int cnt = 0;
            for (int j = 1; j < k; j++) {
                cnt += temp / Math.pow(5, j);
            }
            System.out.println(cnt);
        }
    }
}