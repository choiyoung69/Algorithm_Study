import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //입력 처리
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        //출력할 배열 만들기
        for(int i = 0; i < N; i++){
            int quater25 = arr[i]/25;
            int dime = (arr[i]%25)/10;
            int nickel = arr[i]%25%10/5;
            int penny = arr[i]%25%10%5;

            System.out.println(quater25 + " " + dime + " " + nickel + " " + penny);
        }
    }
}