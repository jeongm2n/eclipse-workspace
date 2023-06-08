package JMBank;

public class Calculate { //계산 클래스 
	
	
	public void deposit(Account acc , int dep) { //입금 함수 
		acc.money += dep;
		System.out.println(acc.name + "에게 " + dep + "만원 입금합니다.");
	}
	
	public void withdraw(Account acc, int draw) { //출금 함수 
		System.out.println(acc.name + "의 계좌에서 " + draw + "만원 출금합니다.");
		acc.money -= draw;
	}
	
}
