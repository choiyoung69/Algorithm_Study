import java.io.*;

public class Main {
    public static int solution(int N){
        int answer = 0;
        boolean[] arr = new boolean[N + 1];

        for(int i = 2; i < N + 1; i++){
            if(arr[i]) continue;
            answer++;
            for(int j = i; j < N+1; j = j + i)
                arr[j] = true;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(Main.solution(N));
    }
}
