package date0504;
import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int point;
		
		while(true) {
			System.out.print("성적을 입력하세요. >> ");
			point = sc.nextInt();
			
			if(point > 10 || point <0) {
				System.out.println("0~10 사이의 점수를 입력하세요.");
			}
			else {
				Grade gd = new Grade(point);
				break;
			}
		}
	}

}
