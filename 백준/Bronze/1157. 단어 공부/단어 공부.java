import java.util.*;

class Main{
    public static String solution(String input){
        String result = input.toUpperCase();
        ArrayList<Character> answer = new ArrayList<Character>();
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();

        for(char ch : result.toCharArray()){
            if(map.get(ch) != null){
                int n = map.get(ch);
                map.put(ch, n + 1);
            }
            else map.put(ch, 1);
        }

        int max = Collections.max(map.values());

        for(char ch : map.keySet()){
            if(map.get(ch) == max){
                answer.add(ch);
            }
        }

        if(answer.size() > 1) return "?";
        return Character.toString(answer.get(0));
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));
    }
}
