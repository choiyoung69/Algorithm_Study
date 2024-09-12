import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> myQ = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            myQ.add(i);
        }

        int cnt = 0;
        while(myQ.size() != 1){
            if(cnt % 2 == 0) myQ.remove();
            else {
                int tmp = myQ.element();
                myQ.remove();
                myQ.add(tmp);
            }
            cnt++;
        }

        System.out.println(myQ.element());
    }
}