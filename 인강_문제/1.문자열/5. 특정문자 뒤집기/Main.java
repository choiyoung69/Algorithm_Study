import java.util.*;

public class Main{
  public static void main(String[] args){
    	String temp = "";
   
    	Scanner sc = new Scanner(System.in);
    	String input = sc.nextLine();
    	
    	// 문자열 확인 후 문자 뒤집기
    	for(int i = 0; i < input.length(); i++){
    		if(Character.isAlphabetic(input.charAt(i))){
    			temp += input.charAt(i);
    		}
    	}
    	String alpha = "";
    	for(int i = 0; i < temp.length(); i++){
    		alpha += temp.charAt(temp.length() - 1 - i);	
    	}
    	
    	//문자열 자리에 뒤집은 문자열 넣기
        String output = "";
        int count = 0;
        for(int i = 0; i < input.length(); i++){
        	if(Character.isAlphabetic(input.charAt(i))){
            	output += alpha.charAt(count);
            	count++;
            }
            else{
                output += input.charAt(i);
            }
        }
               
        System.out.println(output);
  	}
}