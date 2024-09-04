import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[5];
        int sum = 0;
        int middle = 0;

        int number = 0;
        for(int i = 0; i < 5; i++){
            number = Integer.parseInt(br.readLine());
            sum += number;
            arr[i] = number;
        }

        Arrays.sort(arr);
        middle = arr[2];

        sb.append(sum/5);
        sb.append("\n").append(middle);

        System.out.println(sb.toString());

    }
}