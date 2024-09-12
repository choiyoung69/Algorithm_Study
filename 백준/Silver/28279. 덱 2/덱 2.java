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

        int front = 1000000;
        int back = 1000000;
        int size = 0;
        int[] deck = new int[2000000];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch(command){
                case 1 :
                    front--;
                    deck[front] = Integer.parseInt(st.nextToken());
                    size++;
                    break;
                case 2:
                    deck[back] = Integer.parseInt(st.nextToken());
                    back++;
                    size++;
                    break;
                case 3:
                    if(size != 0) {
                        sb.append(deck[front]).append("\n");
                        front++;
                        size--;
                    }
                    else sb.append("-1\n");
                    break;
                case 4:
                    if(size != 0){
                        sb.append(deck[back - 1]).append("\n");
                        back--;
                        size--;
                    }
                    else sb.append("-1\n");
                    break;
                case 5:
                    sb.append(size).append("\n");
                    break;
                case 6:
                    if(size == 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case 7:
                    if(size != 0) sb.append(deck[front]).append("\n");
                    else sb.append("-1\n");
                    break;
                case 8:
                    if(size != 0) sb.append(deck[back - 1]).append("\n");
                    else sb.append("-1\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}