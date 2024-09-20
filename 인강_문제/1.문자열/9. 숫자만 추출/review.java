import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String inputStr = br.readLine();
        ArrayList<Character> numberList = new ArrayList<Character>();

        //숫자로 이루어진 배열
        for(char ch : inputStr.toCharArray()){
            if(Character.isDigit(ch)) numberList.add(ch);
        }

        for(char ch : numberList){
            sb.append(ch);
        }
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
