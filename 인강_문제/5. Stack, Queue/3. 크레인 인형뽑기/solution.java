import java.io.*;
import java.util.*;

public class Main {
    public int solution(int N, int[][] boards, int M, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
      	
      	for(int pos : moves) {
          	for(int i = 0; i < boards.length; i++) {
              	if(boards[i][pos - 1] != 0){
                  	int tmp = boards[i][pos-1];
                  	boards[i][pos-1] = 0;
                  	if(!stack.isEmpty() && tmp == stack.peek()) {
                      	answer += 2;
                      	stack.pop();
                    }
                  	else stack.push(tmp);
                  	break;
                }
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
