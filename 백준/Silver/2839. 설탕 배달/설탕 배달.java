import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int paperBag5, paperBag3;
        int min = -1;
        int count = 0;
        if(N % 3 == 0) min = N / 3;

        while(N - 5 >= 0){
            N = N - 5;
            count++;
            if(N % 3 == 0) min = N / 3 + count;
        }

        System.out.println(min);
    }
}