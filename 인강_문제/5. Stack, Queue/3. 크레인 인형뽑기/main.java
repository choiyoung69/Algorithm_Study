import java.io.*;
import java.util.*;

public class Main {
    public int solution(int N, int[][] boards, int M, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < M; i++) {
            int line = moves[i] - 1;
            int b = -1;
            for (int j = 0; j < N; j++) {
                if(boards[j][line] != 0){
                    b = boards[j][line];
                    boards[j][line] = 0;
                    break;
                }
            }
            if(b == -1) continue; //집은 것의 내용물

            if(!stack.isEmpty() && stack.peek() == b){
                stack.pop();
                answer += 2;
            }
            else{
                stack.push(b);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] b = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] moves = new int[M];
        for (int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, b, M, moves));
    }
}
