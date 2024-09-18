import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine().toLowerCase();
        int length = inputString.length();
        int length_divided_2 = inputString.length()/2;
        boolean flag = true;

        for(int i = 0; i < length_divided_2; i++){
            if(inputString.charAt(i) != inputString.charAt(length - 1 - i)){
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
