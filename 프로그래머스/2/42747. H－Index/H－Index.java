import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        for(int i = citations.length; i >= 1; i--) {
            int index = citations.length - i;
            if(citations[index] >= i) return i;
        }
        
        return 0;
    }
}