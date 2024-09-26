import java.util.Scanner;
import java.io.*;

public class Main {
    static final int CHAR_LENGTH = 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        String str = br.readLine();
        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < CHAR_LENGTH; j++){
                if(str.charAt(i * 7 + j) == '#') sum += Math.pow(2, CHAR_LENGTH - j - 1);
            }
            sb.append((char)sum);
        }

        System.out.println(sb);
    }
}
