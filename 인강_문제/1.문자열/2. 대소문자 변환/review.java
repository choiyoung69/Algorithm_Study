import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String inputStr = br.readLine();
        char ch;

        for(int i = 0; i < inputStr.length(); i++){
            ch = inputStr.charAt(i);

            if(ch >= 65 && ch <= 90) sb.append((char)(ch + 32));
            else sb.append((char)(ch - 32));
        }

        System.out.println(sb);
    }
}
