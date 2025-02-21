import java.io.*;
import java.util.*;

public class Main {
    public int[] solution(int N, int[] arr) {
		for(int i = 0; i < N - 1; i++){
          	int idx = i;
          	for(int j = i + 1; j < N; j++){
              	if(arr[j] < arr[idx]) idx = j;
            }
          	int tmp = arr[i];
          	arr[i] = arr[idx];
          	arr[idx] = tmp;
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
