import java.io.*;

class Main {
    public int[] solution(int N, int[] arr) {
        int[] answer = new int[N];
        int[] addResult = new int[12];

        addResult[0] = 1;
        addResult[1] = 1;
        addResult[2] = 2;

        for (int i = 3; i <= 11; i++) {
            addResult[i] = addResult[i - 3] + addResult[i - 2] + addResult[i - 1];
        }

        for(int i = 0; i < N; i++) {
            answer[i] = addResult[arr[i]];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int x : main.solution(N, arr)) {
            System.out.println(x);
        }
    }
}