import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        
        int sum = 0; 
        int min = 0;
        
        for(int i = start; i <= end; i++){
            if (i == 1) {
                continue; 
            }
            boolean flags = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                //소수가 아니라면
                if(i % j == 0) {
                    flags = false;
                    break;
                }
            }
            if(flags){
                    if(sum == 0) min = i;
                    sum += i;
            }
        }
        if(sum != 0){
            System.out.println(sum);
            System.out.println(min);
        }else{
            System.out.println(-1);
        }
        
    }
}