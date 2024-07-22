import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);

        List<Character> total = new ArrayList<Character>();

        while(N > 0){
            int k = N%B;
            if(k <= 9 && k >= 0) total.add(Character.forDigit(k, B));
            else{
                total.add((char)(k + 55));
            }
            N /= B;
        }
        Collections.reverse(total);
        for(char ch : total){
            System.out.print(ch);
        }
    }
}