import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[] solution(String str, char ch){
        int[] answer = new int[str.length()];
        int p = 1000;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch) p = 0;
            else p++;

            answer[i] = p;
        }

        p = 1000;
        for(int i = str.length() - 1; i >= 0; i--){
            if(str.charAt(i) == ch) p = 0;
            else{
                p++;
                answer[i] = Math.min(p, answer[i]);
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        char ch = st.nextToken().charAt(0);

        for(int x : solution(str, ch)){
            System.out.print(x + " ");
        }
    }
}
