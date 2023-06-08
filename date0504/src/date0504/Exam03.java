package date0504;
import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Division div = new Division();
		
		System.out.print("수를 입력하세요. >> ");
		int num = sc.nextInt();
		
		div.division(num);
	}

}
