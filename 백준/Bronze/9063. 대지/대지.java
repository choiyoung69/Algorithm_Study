import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line;

        int[] x = new int[N];
        int[] y = new int[N];

        int result = 0;

        for(int i = 0; i < N; i++){
            line = br.readLine().split(" ");

            x[i] = (Integer.parseInt(line[0]));
            y[i] = (Integer.parseInt(line[1]));
        }

        Arrays.sort(x);
        Arrays.sort(y);

        result = (x[N - 1] - x[0]) * (y[N - 1] - y[0]);

        System.out.println(result);
    }
}