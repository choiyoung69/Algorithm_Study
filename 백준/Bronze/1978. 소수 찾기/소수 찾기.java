import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        int token;
        int count = 0;

        for(int i = 0; i < n; i++){
            token = Integer.parseInt(st.nextToken());
            if(token == 1) continue;
            boolean flag = false;

            for(int j = 2; j <= Math.sqrt(token); j++) {
                //소수라면 flag = 0
                if (token % j == 0) {
                    flag = true;
                    break;
                }
            }
            if(!flag) count++;
        }
        System.out.println(count);
    }
}