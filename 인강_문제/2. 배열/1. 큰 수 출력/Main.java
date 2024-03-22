//인프런_배열_1번 문제

import java.util.Scanner;

public class Main{
    public static void solution(int length, String input){
        String[] inputArr = input.split(" ");

        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        System.out.print(arr[0] + " ");
        for(int i = 1; i < length; i++){
            if(arr[i-1] < arr[i]){
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int length = kb.nextInt();
        kb.nextLine();
        String input = kb.nextLine();
        solution(length, input);
    }
}