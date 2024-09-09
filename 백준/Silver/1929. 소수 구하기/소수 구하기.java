import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = Math.max(M, N);
        boolean[] arr = new boolean[max + 1];

        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(max); i++){
            if(arr[i]) continue;
            for(int j = i*i; j <= max; j += i){
                arr[j] = true;
            }
        }

        for(int i = N; i <= M; i++){
            if(!arr[i]) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}