import java.io.*;
import java.util.*;

public class Main {
    public int solution(String S, String K) {
        int answer = 0;
        Map<Character, Integer> am = new HashMap<>();
        Map<Character, Integer> bm = new HashMap<>();

        for(char x: K.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        for(int i = 0; i < K.length() - 1; i++){
            am.put(S.charAt(i), am.getOrDefault(S.charAt(i), 0) + 1);
        }

        int lt = 0;
        for(int rt = K.length() - 1; rt < S.length(); rt++){
            am.put(S.charAt(rt), am.getOrDefault(S.charAt(rt), 0) + 1);
            if(am.equals(bm)) answer++;
            am.put(S.charAt(lt), am.getOrDefault(S.charAt(lt), 0) - 1);
            if(am.get(S.charAt(lt)) == 0) am.remove(S.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        System.out.println(main.solution(S, T));
    }
}
