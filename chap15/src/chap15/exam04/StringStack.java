package chap15.exam04;

public class StringStack implements Stack {
	int size;
	int top = -1;
	String stack[];
	
	String temp = null;
	
	int cnt = 0; //저장된 문자열 개수 

	public StringStack(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
		stack = new String[this.size];
		//top = this.size;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return cnt;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return size - cnt;
	}

	@Override
	public String pop() {
		// TODO Auto-generated method stub
		temp = stack[top];
		top--;
		cnt--;
		return temp; 
	} //원소를 뽑아갈 때마다 top의 위치를 한 칸씩 낮추고, cnt를 1씩 낮춤 

	@Override
	public boolean push(String val) {
		// TODO Auto-generated method stub
		if(top >= size-1) { //스택이 꽉 찼으면 false 리턴 
			System.out.println("스택 overflow 발생!!");
			return false;
		}
		else { //스택에 자리가 있으면 값 저장 
			stack[++top] = val;
			cnt++;
			return true;
		}
	}

}
