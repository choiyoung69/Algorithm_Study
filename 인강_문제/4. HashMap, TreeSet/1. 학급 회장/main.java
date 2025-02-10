import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public char solution(int N, String votePaper){
        char answer = 0;
        Map<Character, Integer> voteResult = new HashMap<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            char tempCh = votePaper.charAt(i);

            if (voteResult.containsKey(tempCh)) {
                int curCount = voteResult.get(tempCh);
                voteResult.put(tempCh, ++curCount);
            } else {
                voteResult.put(tempCh, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : voteResult.entrySet()){
            if(max < entry.getValue()){
                answer = entry.getKey();
                max = entry.getValue();
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
