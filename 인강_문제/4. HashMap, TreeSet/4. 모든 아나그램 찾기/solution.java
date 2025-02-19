import java.io.*;
import java.util.*;

public class Main {
    public int solution(String S, String K) {
        int answer = 0;
        Map<Character, Integer> m = new HashMap<>();
        Map<Character, Integer> k = new HashMap<>();
        int lt = 0, rt = 0;

        for(int i = 0; i < K.length(); i++){
            k.put(K.charAt(i), k.getOrDefault(K.charAt(i), 0) + 1);
        }

        for (rt = 0; rt < S.length(); rt++) {
            if(rt - lt + 1 == K.length()) {
                m.put(S.charAt(rt), m.getOrDefault(S.charAt(rt), 0) + 1);
                if(m.equals(k)) {
                    answer++;
                }
                if(m.get(S.charAt(lt)) == 1) m.remove(S.charAt(lt));
                else m.put(S.charAt(lt), m.get(S.charAt(lt)) - 1);
                lt++;
            }
            else {
                m.put(S.charAt(rt), m.getOrDefault(S.charAt(rt), 0) + 1);
            }
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
