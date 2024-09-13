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

        int n = 0;
        while(true){
            if(n*(n+1)/2 < N && N <= (n+1)*(n+2)/2){
                break;
            }
            n++;
        }

        int l  = N - n*(n+1)/2;
        if(n % 2 == 1){
            sb.append(l).append('/').append(n - l + 2);
        }
        else{
            sb.append(n - l + 2).append('/').append(l);
        }

        System.out.println(sb);
    }
}