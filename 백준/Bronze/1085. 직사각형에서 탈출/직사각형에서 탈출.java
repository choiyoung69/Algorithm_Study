import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        
        int min1 = Math.min(x, y);
        int min2 = Math.min((h-y), (w - x));
        System.out.println(Math.min(min1, min2));
    }
}