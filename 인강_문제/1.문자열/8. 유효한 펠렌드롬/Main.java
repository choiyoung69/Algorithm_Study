import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String input = in.nextLine();
    String output = "";
    
    for(int i = 0; i < input.length(); i++){
    	if(Character.isAlphabetic(input.charAt(i))){
          output += input.charAt(i); 
        }
    }
    output = output.toUpperCase();
    for(int i = 0; i < output.length()/2; i++){
      if(output.charAt(i) != output.charAt(output.length() - i - 1)){
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }
}