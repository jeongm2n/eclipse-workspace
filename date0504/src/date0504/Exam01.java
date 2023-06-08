package date0504;
import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] date = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		System.out.print("월을 입력하세요 >> ");
		int month = sc.nextInt();
		
		System.out.println(month + "월의 일수는 " + date[month-1] + "일 입니다.");
		
	}

}
