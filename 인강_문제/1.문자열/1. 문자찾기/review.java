import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String inputStr = br.readLine().toUpperCase();
        char ch = br.readLine().toUpperCase().charAt(0);


        int count = 0;
        for(int i = 0; i < inputStr.length(); i++){
            if(ch == inputStr.charAt(i)) count++;
        }

        System.out.println(count);
    }
}
