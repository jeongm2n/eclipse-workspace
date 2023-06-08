package JMBank;

public class Record {
	
	String accNum;
	String name; //입/출금 대상 
	int money; //입/출금한 돈 
	String kind; //입금인지 출금인지 구별 
	
	public Record(String accNum, String name, int money, String kind) {
		this.accNum = accNum;
		this.name = name;
		this.money = money;
		this.kind = kind;
	}
	
	public String getAccNum() {
		return accNum;
	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}

	public String getKind() {
		return kind;
	}
	
}
