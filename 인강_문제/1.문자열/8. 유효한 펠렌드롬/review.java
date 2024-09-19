import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine();
        int length = inputString.length();
        ArrayList<Character> char_list = new ArrayList<>();

        for(int i = 0; i < length; i++){
            if(Character.isAlphabetic(inputString.charAt(i))){
                char_list.add(Character.toLowerCase(inputString.charAt(i)));
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char c : char_list) {
            answer.append(c);
        }

        boolean flag = true;
        int str_length = answer.length();
        for(int i = 0; i < answer.length()/2; i++){
            if(answer.charAt(i) != answer.charAt(str_length- 1 - i)) {
                flag = false;
                break;
            }
        }
        if(!flag) System.out.println("NO");
        else System.out.println("YES");
    }
}
