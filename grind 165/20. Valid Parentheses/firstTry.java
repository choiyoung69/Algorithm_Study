//내가 푼 solution
//시간 복잡도 O(N) 공간 복잡도 O(N)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char x : s.toCharArray()) {
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
            }
            else if(stack.isEmpty()) return false;
            else if(x == ')' && stack.pop() == '(') continue;
            else if(x == '}' && stack.pop() == '{') continue;
            else if(x == ']' && stack.pop() == '[') continue;
            else return false;
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}

//시간복잡도, 공간복잡도 같지만 좀 더 깔끔하게
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for(char x : s.toCharArray()) {
            if(x == '(') stack.push(')');
            else if(x == '[') stack.push(']');
            else if(x == '{') stack.push('}');
            else if(stack.isEmpty() || stack.pop() != x) return false;
        }
        return stack.isEmpty();
    }
}

//HashMap 사용한 풀이
//다양한 접근 방식이지만 오히려 느릴 수 있음(ContainsValue() 때문에)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char x : s.toCharArray()) {
            if(map.containsValue(x)) {
                stack.push(x);
            }
            else if(map.containsKey(x)) {
                if(stack.isEmpty() || map.get(x) != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }
}


//끝판왕 Solution
//stack은 내부적으로 vector 기반이다. 동기화와 제네릭을 사용하기 때문에 무겁고 + push(), pop() 함수를 호출해야 한다.
//그냥 정적 배열이기 때문에 훨씬 가볍고 계싼이 빠르다. push, pop 없고 바로 접근할 수 있다.. 
//실무에서는 Deque와 ArrayDeque를 쓴다. -> 훨씬 빠르고 가벼움(배열기반)
//성능 : 배열 > Deque > Stack
//가독성 : Deque = Stack > 배열
//Deque
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();  

        for(char x : s.toCharArray()) {
            if(x == '(') stack.push(')');
            else if(x == '{') stack.push('}');
            else if(x == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != x) return false;
        }

        return stack.isEmpty();
    }
}

//Array
class Solution {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int top = -1;

        for(char x : s.toCharArray()) {
            if(x == '(') arr[++top] = ')';
            else if(x == '{') arr[++top] = '}';
            else if(x == '[') arr[++top] = ']';
            else if(top == -1 || arr[top--] != x) return false;
         }

        return top == -1;
    }
}
