import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int cannes = 1;

        while(N > cannes){
            cannes += 6*count;
            count++;
        }
        System.out.println(count);
    }
}