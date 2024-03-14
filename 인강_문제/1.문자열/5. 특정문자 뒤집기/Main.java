import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String input = in.nextLine();

		String output = "";

		for(int i = 0; i < input.length(); i++){
			int check = 0;
			for(int j = 0; j < output.length(); j++){
				if(input.charAt(i) == output.charAt(j)){
					check = 1;
					break;
				}
			}
			if(check == 0){
				output += input.charAt(i);
			}
		}
		System.out.print(output);
	}
}