import java.io.*;
import java.util.*;

class Brick implements Comparable<Brick>{

    int area;
    int height;
    int weight;

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick b) {
        return this.area - b.area;
    }

}

public class Main {
    public int solution(int N, Brick[] bricks) {
        int answer = 0;
        int[] heightSum = new int[N + 1];

        Arrays.sort(bricks);
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if(bricks[i].weight > bricks[j].weight && max < heightSum[j]) {
                    max = heightSum[j];
                }
            }
            heightSum[i] = max + bricks[i].height;
            answer = Math.max(answer, heightSum[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Brick[] bricks = new Brick[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bricks[i] = new Brick(Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()));
        }

        System.out.println(T.solution(N, bricks));
    }
}
