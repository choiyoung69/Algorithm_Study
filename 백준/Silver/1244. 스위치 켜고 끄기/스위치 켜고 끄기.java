import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void line(int gender, int standard, int[] arr) {
        if (gender == 1) {
            for (int i = standard; i < arr.length; i += standard) {
                if(arr[i] == 1) arr[i] = 0;
                else arr[i] = 1;
            }
        } else if (gender == 2) {
            int cnt = 0;
            while (true) {
                if (standard - cnt == 0 || standard + cnt == arr.length) break;
                if(arr[standard - cnt] == arr[standard + cnt]) {
                    if(arr[standard - cnt] == 1) {
                        arr[standard - cnt] = 0;
                        arr[standard + cnt] = 0;
                    }
                    else {
                        arr[standard - cnt] = 1;
                        arr[standard + cnt] = 1;
                    }
                }
                else break;
                cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int standard = Integer.parseInt(st.nextToken());

            line(gender, standard, arr);
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}