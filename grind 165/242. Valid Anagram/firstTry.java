//너무 느린 해결법
//최적의 방법이 따로 있음 
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for(char x : s.toCharArray()) {
            sMap.put(x, sMap.getOrDefault(x, 0) + 1);
        }

        for(char x : t.toCharArray()) {
            int now = sMap.getOrDefault(x, 0);
            if(now == 0) return false;
            sMap.put(x, now - 1);
        }

        for(int x : sMap.values()) {
            if(x != 0) return false;
        }

        return true;
    }
}

//시간복잡도 자체는 NlogN이지만, 해시맵보다 더 빠른 경우가 있음(해쉬맵은 오버헤드가 존재해서)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        if(!Arrays.equals(sArray, tArray)) {
            return false;
        }
        return true;
    }
}

//시간복잡도 N이고 공간복잡도 1임
//해쉬맵보다 빠름
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int x : arr) {
            if(x != 0) return false;
        }
        return true;
    }
}

//위와 비슷한데 charAt안써서 더 빠름
