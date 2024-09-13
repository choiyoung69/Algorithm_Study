import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int currentNumber = 1; // 지금 간식 받을 번호
        st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());

            if(k > currentNumber) s.push(k);
            else currentNumber++;

            while(!s.isEmpty() && s.peek() == currentNumber){
                s.pop();
                currentNumber++;
            }
        }

        if(currentNumber == N + 1) System.out.println("Nice");
        else System.out.println("Sad");
    }
}