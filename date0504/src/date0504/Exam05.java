package date0504;
import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String number;
		
		System.out.print("주민등록번호를 입력하세요. >> ");
		number = sc.next();
		
		int year = Integer.parseInt(number.substring(0,2));
		int month = Integer.parseInt(number.substring(2,4));
		int day = Integer.parseInt(number.substring(4,6));
		int fm = Integer.parseInt(number.substring(7,8));
		
		System.out.println("19" + year + "년 " + month + "월 " + day + "일 출생입니다.");
		
		switch(fm) {
			case 1,3 :
				System.out.println("남자입니다.");
				break;
			case 2,4 :
				System.out.println("여자입니다.");
				break;
		}
	}

}
