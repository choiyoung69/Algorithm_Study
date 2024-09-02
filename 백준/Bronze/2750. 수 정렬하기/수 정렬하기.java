import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Narr = new int[N];

        //입력 처리 for문
        for(int i = 0; i < N; i++){
            Narr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(Narr);

        for (int i = 0; i < N; i++) {
            System.out.println(Narr[i]);
        }
    }
}