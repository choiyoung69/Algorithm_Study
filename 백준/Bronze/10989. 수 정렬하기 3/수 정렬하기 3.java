import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] arrays = new int[N];
        int[] count = new int[100000];
        int[] result = new int[N];

        int number = 0;
        for(int i = 0; i < N; i++){
            number = Integer.parseInt(br.readLine());
            arrays[i] = number;
            count[number]++;
        }

        for(int i = 1; i < count.length; i++){
            count[i] += count[i - 1];
        }

        for(int i = 0; i < N; i++){
            int value = arrays[i];
            count[value]--;
            result[count[value]] = value;
        }

        for(int i = 0; i < N; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}