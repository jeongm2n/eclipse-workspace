package date0504;
import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String[] season = {"겨울", "겨울", "봄", "봄", "봄", "여름", "여름", "여름", "가을", "가을", "가을", "겨울"};
		int month;
		
		while(true) {
			System.out.print("월을 입력하세요. >> ");
			month = sc.nextInt();
			
			if(month == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println(month + "월은 " + season[month] + "입니다.");
			}
		}
		
	}

}
