import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		int num = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();

		try{
			num = Integer.parseInt(st);
			if((num % 4 == 0 && num % 100 != 0 ) || (num % 400 == 0)){
				System.out.print("1");
			}
			else {
				System.out.print("0");
			}
		} catch(NumberFormatException e){
		System.out.println("[System] 잘못된 입력입니다. 다시 입력해주세요");
		}
	}
}