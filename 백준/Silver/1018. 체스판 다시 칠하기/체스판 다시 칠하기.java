import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static public int solution(boolean[][] arrWB, boolean[][] arrBW, int i, int j){
        int min1 = 0;
        int min2 = 0;

        for(int k = i; k < i + 8; k++){
            for(int r = j; r < j + 8; r++){
                if(arrWB[k][r]) min1++;
                if(arrBW[k][r]) min2++;
            }
        }

        return Math.min(min1, min2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] wb_arr = {'W', 'B'};
        char[] bw_arr = {'B', 'W'};

        boolean[][] arrWB = new boolean[N][M];
        boolean[][] arrBW = new boolean[N][M];
        int number = 0;

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M - 1; j++){
                char ch = line.charAt(j);
                if(ch != wb_arr[number%2]) arrWB[i][j] = true;  //값이 true면 교체해야 됨
                if(ch != bw_arr[number%2]) arrBW[i][j] = true;  //값이 true면 교체해야 됨
                number++;
            }
            char last = line.charAt(M-1);
            if(last != wb_arr[number%2]) arrWB[i][M - 1] = true;
            if(last != bw_arr[number%2]) arrBW[i][M - 1] = true;
            if(M % 2 == 1) number++;
        }

        int answer = Integer.MAX_VALUE;
        int value = 0;

        for(int i = 0; i < N - 7; i++){
            for(int j = 0; j < M - 7; j++){
                value = solution(arrWB, arrBW, i, j);
                if(answer > value){
                    answer = value;
                }
            }
        }

        System.out.println(answer);
    }
}