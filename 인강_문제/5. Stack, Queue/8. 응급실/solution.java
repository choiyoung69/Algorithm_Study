import java.io.*;
import java.util.*;

class Person {
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
    public int solution(int N, int M, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            q.add(new Person(i, arr[i]));
        }
        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x : q) {
                if(x.priority > tmp.priority){
                    q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp != null){
                answer++;
                if(tmp.id == M) return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(main.solution(N, M, arr));
    }
}
