import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int answer = 0;
        int divi;

        for(int i = 1; i < N; i++){
            sum = i;
            divi = i;
            String str = Integer.toString(i);

            for(int j = str.length() - 1; j >= 0; j--){
                sum += (int)(divi / Math.pow(10, j));
                divi = (int)(divi % Math.pow(10, j));
            }
            if(sum == N) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}