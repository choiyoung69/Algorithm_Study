import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public String solution(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        if(map1.size() != map2.size()) {
            return "NO";
        }

        for (char ch : map1.keySet()) {
            if (map1.get(ch) != map2.getOrDefault(ch, 0)) {
                return "NO";
            }
        }

        return "YES";
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        System.out.println(main.solution(word1, word2));
    }
}
