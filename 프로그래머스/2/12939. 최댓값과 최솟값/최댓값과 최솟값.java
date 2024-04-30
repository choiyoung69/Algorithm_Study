import java.util.*;
import java.util.Vector;


class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] arrInt = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        
        sb.append(Arrays.stream(arrInt).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(arrInt).max().getAsInt());
        
        answer = sb.toString();
        return answer;
    }
}