import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2; i < num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    public List<Integer> solution(int N, int[] arr){
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0){
                int t = tmp% 10;
                res = res*10 + t;
                tmp = tmp/10;
            }
            if(isPrime(res)) answer.add(res);
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int x : main.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }
}
