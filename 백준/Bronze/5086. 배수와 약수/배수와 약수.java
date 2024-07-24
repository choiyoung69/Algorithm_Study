import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        while(true){
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            if(input1 == 0 && input2 == 0) break;

            if(input1 % input2 == 0) sb.append("multiple\n");
            else if(input2 % input1 == 0) sb.append("factor\n");
            else sb.append("neither\n");
        }
        System.out.println(sb.toString());
    }
}