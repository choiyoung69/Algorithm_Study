import java.util.Scanner;

public class Main{
    public static int solution(int n,int[] arr){
        int max = arr[0], answer = 1;

        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(Main.solution(n, arr));
    }
}