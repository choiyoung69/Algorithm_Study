import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        int sum = 0;
        for(int a : setA){
            if(setB.contains(a)) count++;
        }
        sum = setB.size() - count;

        count = 0;
        for(int b : setB){
            if(setA.contains(b)) count++;
        }
        sum += setA.size() - count;

        System.out.println(sum);
    }
}