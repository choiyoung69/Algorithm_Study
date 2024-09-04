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

        boolean[] arrays = new boolean[2000001];

        for(int i = 0; i < N; i++){
            arrays[Integer.parseInt(br.readLine()) +1000000] = true;
        }

        for(int i = 0; i < arrays.length; i++){
            if(arrays[i])
                sb.append(i - 1000000).append("\n");
        }
        System.out.println(sb);
    }
}