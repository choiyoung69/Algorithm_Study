import java.util.Arrays;
import java.util.*;

class Solution {
    
    public void pick(int[] course, String candidateCourse, 
                     String pickedMenu, int index, Map<String, Integer> candidates) {
        // 나가는 포인트 찾기
        if (index == pickedMenu.length()
            || candidateCourse.length() == course[course.length - 1]) {
            return;
        }
        
        char ch = pickedMenu.charAt(index);
        String nextCourse = candidateCourse + ch;

        // 현재 문자를 선택해서 새로 만든 조합만 기록
        for (int length : course) {
            if (nextCourse.length() == length) {
                int count = candidates.getOrDefault(nextCourse, 0);
                candidates.put(nextCourse, count + 1);
                break;
            }
        }

        // 현재 문자 선택
        pick(course, nextCourse, pickedMenu, index + 1, candidates);

        // 현재 문자 제외
        pick(course, candidateCourse, pickedMenu, index + 1, candidates);
    }
    
    
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        Map<String, Integer> candidates = new HashMap<String, Integer>();
        
        for (String order : orders) {
            char[] menus = order.toCharArray();
            Arrays.sort(menus);

            pick(course, "", new String(menus), 0, candidates);
        }
        
        // 길이 10도 인덱스로 사용하므로 크기는 11
        int[] maxCounts = new int[11];

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            String menu = entry.getKey();
            int count = entry.getValue();

            maxCounts[menu.length()] =
                Math.max(maxCounts[menu.length()], count);
        }
    
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            String menu = entry.getKey();
            int count = entry.getValue();
            
            if (count == maxCounts[menu.length()] && count >= 2) {
                answer.add(menu);
            }
        }
        
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
}