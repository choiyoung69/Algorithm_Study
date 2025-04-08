//내가 푼 풀이
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for(char x : s.toCharArray()) {
            if(Character.isAlphabetic(x)) 
                sb.append(Character.toLowerCase(x));
            else if(Character.isDigit(x))
                sb.append(x);
        }
        String tmp = sb.toString();
        for(int i = 0; i < tmp.length()/2; i++) {
            if(tmp.charAt(i) != tmp.charAt(tmp.length() - 1 - i))
                return false;
        }
        return true;
    }
}

//투 포인터로 푸는 법
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

//투포인터 + 아스키코드
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            int var1 = var(s.charAt(left));
            if(var1 == -1) {
                left++;
                continue;
            }
            int var2 = var(s.charAt(right));
            if(var2 == -1) {
                right--;
                continue;
            }

            if(var1 != var2) return false;
            left++;
            right--;
        }
        return true;
    }

    public int var(char ch) {
        if(ch >= 'a' && ch <= 'z') return ch;
        else if(ch >= 'A' && ch <= 'Z') return ch - 'A' + 'a';
        else if(ch >= '0' && ch <= '9') return ch;
        return -1;
    }
}

//성능은 느리지만 정규표현식을 사용하는 방법
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}

//성능이 좋지는 않지만 문자열 reverse
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        StringBuilder sb = new StringBuilder(s);
        String reverseString = sb.reverse().toString();

        if(!s.equals(reverseString)) return false;
        return true;
    }
}
