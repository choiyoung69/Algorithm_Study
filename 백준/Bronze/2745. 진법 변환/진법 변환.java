import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        String N = arr[0];
        int B = Integer.parseInt(arr[1]);

        int total = 0;

        for(int i = 0; i < N.length(); i++){
            char ch = N.charAt(N.length() - 1 - i);
            int rl = 0;
            if(ch <= 57 && ch >= 48){
                rl = (int)(ch - 48);
            }
            else{
                rl = (int)(ch - 55);
            }
            total += rl*Math.pow(B, i);
        }
        System.out.println(total);
    }
}