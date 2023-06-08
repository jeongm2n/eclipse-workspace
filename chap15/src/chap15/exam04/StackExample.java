package chap15.exam04;
import java.util.Scanner;

public class StackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("스택의 크기를 정하세요. >> ");
		int size = sc.nextInt();
		StringStack sts = new StringStack(size);
	
		boolean chk;
		int n;
		
		while(true) {
			
			System.out.println("\n1.push | 2.pop | 3.length | 4.capacity | 5.종료");
			n = sc.nextInt();
			
			switch(n) {
				case 1:
					System.out.print("스택에 저장할 문자열을 입력하세요. >> ");
					String st = sc.next();
					
					if((chk=sts.push(st))) { //스택에 자리가 있으면 
						System.out.println("[" + st + "] 가 저장되었습니다.");
					}
					else { //스택이 꽉 찼으면 
						continue;
					}
					break;
					
				case 2:
					System.out.println("스택의 가장 위에 있는 값을 가져옵니다.");
					System.out.println(sts.pop());
					break;
					
				case 3:
					System.out.println("스택에 저장된 문자열의 개수 : " + sts.length());
					break;
					
				case 4:
					System.out.println("스택에 저장 가능한 개수 : " + sts.capacity());
					break;
					
				case 5:
					System.exit(0);
			}
			
		}
	}

}
