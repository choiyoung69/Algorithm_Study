import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int solution(String str, char t){
        int answer = 0;

        String upper_str = str.toUpperCase();
        char upper_t = Character.toUpperCase(t);

//        for(int i = 0; i < upper_str.length(); i++){
//            if(upper_str.charAt(i) == upper_t) answer++;
//        }

        for (char k : upper_str.toCharArray()) {
            if(k == upper_t) answer++;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char t = br.readLine().charAt(0);

        System.out.println(Main.solution(str, t));
    }
}
