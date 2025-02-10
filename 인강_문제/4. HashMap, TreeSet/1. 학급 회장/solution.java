import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public char solution(int N, String votePaper){
        char answer = 0;
        Map<Character, Integer> voteResult = new HashMap<>();
        int max = 0;

        for (char x : votePaper.toCharArray()) {
            voteResult.put(x, voteResult.getOrDefault(x, 0) + 1);
        }

        for (char x : voteResult.keySet()) {
            if (max < voteResult.get(x)) {
                max = voteResult.get(x);
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String votePaper = br.readLine();

        System.out.println(main.solution(N, votePaper));
    }
}
