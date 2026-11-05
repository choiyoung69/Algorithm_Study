import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> prefixes = new HashSet<>();
        
        for(String phone : phone_book) {
            for(int i = 1; i < phone.length(); i++) {
                prefixes.add(phone.substring(0, i));
            }
        }
        
        for(String phone : phone_book) {
            if(prefixes.contains(phone)) {
                return false;
            }
        }
        
        return true;
    }
}