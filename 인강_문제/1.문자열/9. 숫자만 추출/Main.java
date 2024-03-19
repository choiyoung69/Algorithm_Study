import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    String input = in.nextLine();
    
    String temp = "";
    
    for(char c : input.toCharArray()){
      if(Character.isDigit(c)){
        temp += c;
      }
    }
    System.out.println(Integer.parseInt(temp));
  }
}