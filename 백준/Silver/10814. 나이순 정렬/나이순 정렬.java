import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] p = new StringBuilder[201];
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < 201; i ++){
            p[i] = new StringBuilder();
        }

        int age;
        String name;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();

            p[age].append(age).append(' ').append(name).append("\n");
        }

        for (StringBuilder sbarr : p) {
            sb.append(sbarr);
        }
        System.out.println(sb);
    }
}