import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public String solution(String word1, String word2) {
        String answer = "YES";
        Map<Character, Integer> map = new HashMap<>();

        for (char x : word1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(char x : word2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }

            map.put(x, map.get(x) - 1);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        System.out.println(main.solution(word1, word2));
    }
}
