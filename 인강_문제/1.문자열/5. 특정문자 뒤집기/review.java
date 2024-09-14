import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();

        ArrayList<Character> alpha = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)){  //문자라면
                alpha.add(ch);
            }
        }

        char[] alpha_arr = new char[alpha.size()];
        //뒤집기
        for(int i = 0; i < alpha.size(); i++){
            alpha_arr[i] = alpha.get(alpha.size() -1 - i);
        }

        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char tmp = str.charAt(i);
            if((tmp >= 65 && tmp <= 90) || (tmp >= 97 && tmp <= 122)) {
                sb.append(alpha_arr[count]);
                count++;
            }
            else sb.append(tmp);
        }

        System.out.println(sb);
    }
}
