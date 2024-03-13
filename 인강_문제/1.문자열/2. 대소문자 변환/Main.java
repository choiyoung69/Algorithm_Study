import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String output = "";

		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();


		for(int i = 0; i < inputString.length(); i++){
			char ch = inputString.charAt(i);
			if(Character.isUpperCase(ch)){
				output += String.valueOf(ch).toLowerCase();
			}
			else{
				output += String.valueOf(ch).toUpperCase();
			}
		}
		System.out.print(output);
	}
}