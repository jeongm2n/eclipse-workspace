package date0504;

public class Division {

	public void division(int num) {
		int share = num/3;
		int remainder = num%3;
		
		System.out.println(num + "을 3으로 나눕니다.");
		System.out.println("몫 : " + share + ", 나머지 : " + remainder);
	}
}
