package JMBank;

public class Account {
	
	private String accNum; //계좌번호 
	String name; //이름 
	String pwd; //비밀번호 
	
	int money; //기본으로 들어있는 돈  
	
	public Account(String accNum, String name, String pwd, int money) {
		this.accNum = accNum;
		this.name = name;
		this.pwd = pwd;
		this.money = money;
	}
	
	public String getAccNum() {
		return accNum;
	}

	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public int getMoney() {
		return money;
	}
}
