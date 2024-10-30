import java.io.*;

public class Main {
//    public static int[] solution(int N){
//        int[] answer = new int[N];
//
//        answer[0] = 1;
//        answer[1] = 1;
//
//        for(int i = 2; i < N; i++){
//            answer[i] = answer[i-1] + answer[i-2];
//        }
//
//        return answer;
//    }

    public static void solution(int N){
        int a = 1;
        int b = 1;
        int c;

        System.out.print(a + " " + b + " ");
        for(int i = 2; i < N; i++){
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        for(int k : Main.solution(N)){
//            System.out.print(k + " ");
//        }
        Main.solution(N);
    }
}
