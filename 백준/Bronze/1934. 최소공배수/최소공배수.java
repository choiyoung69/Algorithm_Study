import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        int a;
        int b;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            set.clear();

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            int result = a * b;
            while(b != 0){
                int r = a % b;

                a = b;
                b = r;
            }
            sb.append(result / a).append("\n");
        }

        System.out.println(sb);

    }
}