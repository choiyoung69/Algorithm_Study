import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class Main {
    public static int solution(int N, int[] arr){
        int count = 1;
        int max = arr[0];

        for(int i = 1; i < arr.length; i++){
            if (arr[i] > max) {
                count++;
                max = arr[i];
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] intArray = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        System.out.println(solution(N, intArray));
    }
}
