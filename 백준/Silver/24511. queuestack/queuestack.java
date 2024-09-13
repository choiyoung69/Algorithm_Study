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

        Deque<Integer> dq = new ArrayDeque<>();

        //첫쨰줄 stackqueue 길이 입력
        int N = Integer.parseInt(br.readLine());

        //stack 인지 queue인지 구분 입력
        st = new StringTokenizer(br.readLine());
        int[] sq = new int[N];
        for(int i = 0; i < N; i++){
            sq[i] = Integer.parseInt(st.nextToken());
        }

        //stack queue의 운소 배열 입력
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //셋째 줄 입력
        int cnt = Integer.parseInt(br.readLine());

        //넷째 줄 배열 읿력
        int[] input = new int[cnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        //다섯째 줄 배열 입력
        for(int i = 0; i < N; i++){
            if(sq[i] == 0) dq.addLast(arr[i]);
        }

        for(int i = 0; i < cnt; i++){
            dq.addFirst(input[i]);
            sb.append(dq.removeLast()).append(" ");
        }
        System.out.println(sb);
    }
}