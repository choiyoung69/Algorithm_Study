import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int MAX_NUMBER = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < MAX_NUMBER; i++) {
            if ((N & (1 << i)) != 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
