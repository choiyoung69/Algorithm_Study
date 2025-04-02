import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {
    int time;
    char state;

    public Person(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Person o) {
        if(this.time != o.time) {
            return this.time - o.time;
        }
        else {
            return this.state - o.state;
        }
    }
}

public class Main { ;
    public int solution(ArrayList<Person> arr) {
        int answer = 0;
        Collections.sort(arr);
        int cnt = 0;

        for(Person p : arr) {
            if(p.state == 's') {
                cnt++;
                answer = Math.max(answer, cnt);
            } else cnt--;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Person> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr.add(new Person(f, 's'));
            arr.add(new Person(s, 'e'));
        }

        System.out.println(T.solution(arr));
    }
}
