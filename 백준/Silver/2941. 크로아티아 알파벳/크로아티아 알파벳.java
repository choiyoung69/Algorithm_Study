import java.util.*;

class Main{
    public static int solution(String input){
        String[] alpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String a : alpha){
            input = input.replace(a, "*");
        }
        return input.length();
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));
    }
}