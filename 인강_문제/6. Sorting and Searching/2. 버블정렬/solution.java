import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int N, int[] arr) {
        for(int i = 0; i < N - 1; i++){
          	for(int j = 0; j < N - i - 1; j++){
              	if(arr[j + 1] < arr[j]){
                  	int tmp = arr[j];
                  	arr[j] = arr[j+1];
                  	arr[j+1] = tmp;
                }
            }
        }
              	
        return arr;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int x : main.solution(N, arr)) {
            System.out.print(x + " ");
        }
    }
}
