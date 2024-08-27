import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N_len = str.length();
        int N = Integer.parseInt(str);

        int answer = 0;
        int sum = 0;
        int divi;

        for(int i = N - 9 * N_len; i < N; i++){
            sum = 0;
            divi = i;

            while(divi != 0){
                sum += divi % 10;
                divi /= 10;
            }

            if(sum + i == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}