import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int totalChar = Integer.parseInt(in.nextLine());
	String input = in.nextLine();

    String answer = "";
    
    for(int i = 0; i < totalChar; i++){
      int ch = 0;
      for(int j = 6; j >= 0; j--){
        if(input.charAt(7 * i + 6 - j) == '#'){
          ch += Math.pow(2, j);
      	}
      }
      answer += (char)ch;
    }
 	System.out.println(answer);
  }
}