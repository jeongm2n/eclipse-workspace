package JMBank;
import java.util.Scanner;
import java.util.ArrayList;

public class Run {
	Scanner sc = new Scanner(System.in);
	
	MysqlConnect mysql = new MysqlConnect(); //mysql과 연동하는 클래스의 객체 

	ArrayList<Account> accs = new ArrayList<Account>(); //Account 클래스 객체를 담는 ArrayList 생성 
	
	ArrayList<Record> recs = new ArrayList<Record>(); //거래내역을 담는 Record 클래스 객체를 담는 ArrayList 생성 
	
	Calculate cal = new Calculate();
	
	String usrname; //거래 내역에 기록할 이름 
	int price; //거래 내역에 기록할 돈 
	String what[] = {"입금", "출금"};
	
	public Run() {
		accs = mysql.getBank(); //BANK테이블의 모든 정보를 ArrayList accs에 복사 
	}
	
	public void start() {
		System.out.println("\n=======================================================");
		System.out.println("1.계좌 개설 | 2.은행 업무 | 3.계좌 삭제 | 4.계좌 목록 | 5.종료");
		System.out.println("=======================================================");
	}
	
	public void makeAccount() { //계좌 개설 함수 
		
		System.out.println("\n 계좌를 개설합니다.");

		System.out.println("\n계좌 번호, 이름, 비밀번호를 입력하세요. ");
		System.out.print("계좌 번호 : ");
		String accNum = sc.next();
		
		for(Account acc : accs) {
			if(accNum.equals(acc.getAccNum())) {
				System.out.println("이미 있는 계좌번호입니다!"); //이미 있는 계좌이면 개설 못하게 
				return;
			}
		}
		
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("비밀번호 : ");	
		String pwd = sc.next();
	
		Account acc = new Account(accNum, name, pwd, 500); //입력한 새로운 계좌 정보 
		accs.add(acc); 
		mysql.insertBANK(acc); //mysql BANK 테이블에 새로운 계좌 데이터 입력 
	}
	
	class Service { //은행 업무 클래스 
		String num;
		String pwd;
		
		public void chkuser() { //본인 확인 함수 
			System.out.println("본인의 계좌번호와 비밀번호를 입력하세요.");
			System.out.print("계좌번호 >> ");
			num = sc.next();
			System.out.print("비밀번호 >> ");
			pwd = sc.next();
		}
		
		public void plus() { //입금/송금 함수 
			
			System.out.println("입금할 계좌번호를 입력하세요.");
			String n = sc.next();
			int cost;
			
			for(Account acc1 : accs) {
				if (n.equals(acc1.getAccNum())) { //입금하려는 계좌가 존재하는 계좌이면 
					usrname = acc1.name; //거래내역에 추가하기 위해 입금하려는 상대방의 이름을 usrname에 저장해둠 
					System.out.println("현재 잔액 : " + acc1.getMoney());
					System.out.print("얼마를 입금하시겠습니까? (단위 : 만원) >> ");
					cost = sc.nextInt();
					price = cost;
					
					for(int i=1; i<4; i++) {
						System.out.println(i + "...");
						try { Thread.sleep(1000);} catch (InterruptedException e) {}
						}
					cal.deposit(acc1, cost);
					mysql.update(acc1); //상대방 계좌에 입금된 돈까지 더해서 db 업데이트 
					
					if(!(n.equals(num))) { //타인의 계좌에 입금하는 경우 본인의 계좌에서 돈이 빠져나가게 설정 
						for(Account acc2 : accs) {
							if(num.equals(acc2.getAccNum())) {
								cal.withdraw(acc2, cost);
								mysql.update(acc2); //상대방 계좌에 입금한 금액만큼 내 계좌에서 빠져나간 금액으로 db 업데이트 
								break;
							}
						}
					}
					break;
				}
			}
		}
		
		public void minus() { //출금 함수 
			usrname = "내 통장"; 
			
			System.out.print("얼마를 출금하시겠습니까? >> ");
			int money = sc.nextInt();
			price = money;
			
			for(Account acc : accs) {
				if(num.equals(acc.getAccNum())) {
					if(money > acc.getMoney()) {
						System.out.println("잔액이 부족합니다! 현재 잔액 : " + acc.getMoney());
						break;
					}
					else {
						for(int i=1; i<4; i++) {
							System.out.println(i + "...");
							try { Thread.sleep(1000);} catch (InterruptedException e) {}
								// TODO Auto-generated catch blocke.printStackTrace();
						}
						cal.withdraw(acc, money); 
						mysql.update(acc);
						break;
					}
				}
			}
		}
		
		public void showRest() { //잔액 보기 
			
			for(Account acc : accs) {
				if(num.equals(acc.getAccNum())) {
					System.out.println("잔액 : " + acc.getMoney() + "만원");
					break;
				}
			}
		}
		
		public void showRecord(Account acc) {
			int i = 1;
			ArrayList<Record> r = new ArrayList<Record>();
			
			r = mysql.joinRECORD(recs, acc);
			//테이블 join을 위해 모든 거래내역이 담겨있는 recs와 해당 계좌번호의 정보를 MysqlConnect 클래스의 joinRECORD함수로
			//보내서 join된 결과를 담고 있는 ArrayList r 을 반환해
			
			System.out.println("\n====================거래내역====================");
			for(Record rec : r) {
				if(rec.kind.equals(what[0])){
					System.out.println(i + "." + rec.getName() + "에게 " + rec.getMoney() + "만원 " + rec.getKind());
				}
				else {
					System.out.println(i + "." +rec.getName() + "에서 " + rec.getMoney() + "만원 " + rec.getKind());
				}
				i++;
			}
			System.out.println("==============================================");
		}
		
		
		public void service() {
			System.out.println("\n<<은행 업무를 시작합니다.>>");
				
			int n;
				
			while(true) {
					
				chkuser();
					
				while(true) {
						
					for(Account acc : accs) {
						if(num.equals(acc.getAccNum()) && pwd.equals(acc.getPwd())) {
							System.out.println("\n<" + acc.name + "> 의 계좌입니다.");
									
							System.out.println("1.입금/송금 | 2.출금 | 3.잔액 확인 | 4.거래내역보기 | 5.뒤로가기");
							System.out.print("기능을 선택하세요 >> ");
							n = sc.nextInt();
										
							switch(n) {
								case 1: //입금, 송금하기 
									plus();
									mysql.insertRECORD(num, usrname, what[0],price); //입금 내역을 거래내역 RECORD 테이블에 추가 
									break;
												
								case 2: //출금하기 
									minus();
									mysql.insertRECORD(num, usrname, what[1],price); //출금 내역을 거래내역 RECORD 테이블에 추가 
									break;
												
								case 3: //잔액 확인하기 
									showRest();
									break;
												
								case 4:	//거래 내역 보기 
									recs = mysql.getRecord(); //거래내역 RECORD 테이블의 모든 정보 추출 
									showRecord(acc);
									break;
											 
								case 5: //뒤로 가기 
									run();
									break;
							}
						return;
						}
					}
					System.out.println("!!계좌번호나 비밀번호가 다릅니다. 다시 시도해주세요.!!");
					break;
				}
			}
		}
		
	}
	
	public void deleteAccount() { //계좌 삭제하기 
		
		System.out.print("삭제할 계좌번호를 입력하세요. >> ");
		String n = sc.next();
		
		for(Account acc : accs) {
			if(n.equals(acc.getAccNum())) {
				mysql.delete(acc);
				accs.remove(acc);
				break;
			}
		}
		
	}
	
	public void showAccount() { //계좌 목록 보기 
		System.out.println("\n계좌 목록을 확인합니다.");
		System.out.println("--------------------------------------------");
		System.out.println(" 계좌번호\t\t|이름\t|잔액 ");
	
		for(Account acc : accs) {
			System.out.println("[" + acc.getAccNum() + "\t|" + acc.getName() + "\t|" + acc.getMoney() + "만원]");
		}
	}
	
	
	public void run() { 
		
		while(true) {
			
			start();
			System.out.print("어떤 업무를 하시겠습니까?  >> ");
			int func = sc.nextInt();
			
			switch(func) {
				case 1: //계좌 개설하기 
					makeAccount();
					break;
					
				case 2: //은행 업무 시작하기 
					Service s = new Service();
					s.service();
					break;
					
				case 3: //계좌 삭제하기 
					deleteAccount();
					break;
					
				case 4: //계좌 목록 보기 
					showAccount();
					break;
					
				case 5: //프로그램 종료하기 
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
			}
		}
	}
}
