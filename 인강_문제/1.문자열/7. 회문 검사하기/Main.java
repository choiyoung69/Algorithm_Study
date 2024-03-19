import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    int check = 0;
    String answer = "NO";
    
    Scanner in=new Scanner(System.in);
    String input = in.nextLine();
    input = input.toUpperCase();
    
    for(int i = 0; i < input.length()/2; i++){
      if(input.charAt(i) != input.charAt(input.length() - 1 - i)){
        check = 1;
      }
    }
    if(check == 0){
      answer = "YES";
    }
	System.out.println(answer);
  }
}
