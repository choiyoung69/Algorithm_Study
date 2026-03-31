import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int n = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if(str.equals("all")) {
                n = (1 << 21) - 1;
                continue;
            }
            else if(str.equals("empty")) {
                n = 0;
                continue;
            }
            int k = Integer.parseInt(st.nextToken());

            if(str.equals("add")) n |= (1 << k);
            else if(str.equals("remove")) n &= ~(1 << k);
            else if (str.equals("check")) sb.append((n & (1 << k)) == 0 ? 0 : 1).append('\n');
            else if (str.equals("toggle")) n ^= (1 << k);
        }
        System.out.println(sb);
    }
}