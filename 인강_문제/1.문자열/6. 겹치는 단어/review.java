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

        Set<Character> set = new LinkedHashSet<>();

        for(int i = 0; i < str.length(); i++){
            set.add(str.charAt(i));
        }

        for(char ch : set){
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
