import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((v1, v2) -> (v2 + v1).compareTo(v1 + v2))
            .collect(Collectors.joining());
        
        return answer.startsWith("0") ? "0" : answer;
    }
}