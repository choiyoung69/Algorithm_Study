import java.util.*;

public class Main {
	public static void main(String[] args){
		int count = 0;

		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine().toUpperCase();
		char inputChar = scanner.nextLine().toUpperCase().charAt(0);

		for(int i = 0; i < inputString.length(); i++){
			if(inputString.charAt(i) == inputChar){
				count++;
			}
		}
		System.out.print(count);
	}
}