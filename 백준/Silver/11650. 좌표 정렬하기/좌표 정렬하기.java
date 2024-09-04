import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (c1, c2) ->{
            if(c1[0] == c2[0]){
                return c1[1] - c2[1];
            }
            else{
                return c1[0] - c2[0];
            }
        });

        for(int i = 0; i < N; i++){
            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}