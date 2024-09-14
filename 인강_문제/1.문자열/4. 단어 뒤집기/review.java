import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String str;
        for(int i = 0; i < N; i++){
            str = br.readLine();

            for(int j = 0; j < str.length(); j++){
                sb.append(str.charAt(str.length() - 1 - j));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
