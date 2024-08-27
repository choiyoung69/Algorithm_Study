import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] Narr = new int[N];
        for(int i = 0; i < N; i++){
            Narr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int sum = 0;

        for(int i = 0; i < N - 2; i++){
            for(int j = i+1; j < N - 1; j++){
                for(int k = j + 1; k < N; k++){
                    sum = Narr[i] + Narr[j] + Narr[k];
                    if(sum == M){
                        answer = sum;
                        break;
                    }
                    if(answer < sum && sum < M) answer = sum;
                }
            }
        }

        System.out.println(answer);
    }
}