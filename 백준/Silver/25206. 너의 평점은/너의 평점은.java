import java.util.*;

class Main {
    public static void main(String args[]) {
        double totalSum = 0;
        double scoreSum = 0;
        Scanner sc = new Scanner(System.in);
        String[] gradeList = {"A+", "A0","B+","B0","C+","C0","D+","D0","F","P"};
        double[] grade = {4.5,4.0,3.5,3.0,2.5,2.0,1.5,1.0,0.0,0.0};
        for(int i = 0; i < 20; i++) {
            String[] arr = sc.nextLine().split(" ");
            for(int j = 0; j < gradeList.length; j++) {
                if(arr[2].equals(gradeList[j])){
                    totalSum += Double.parseDouble(arr[1]) * grade[j];
                    if(j != 9){
                        scoreSum += Double.parseDouble(arr[1]);
                    }
                }
            }
        }
        System.out.println(totalSum/scoreSum);
    }
}