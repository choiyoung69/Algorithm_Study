import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        br.close();

        for(int i = 2; i <= Math.sqrt(N); i++){
            while(N % i == 0){
                N /= i;
                sb.append(i).append("\n");
            }
        }
        if(N != 1) sb.append(N);
        System.out.println(sb);
    }
}