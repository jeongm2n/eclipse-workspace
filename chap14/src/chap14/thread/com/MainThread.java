package chap14.thread.com;

public class MainThread {

	public MainThread() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				System.out.println("hi");
			}
			
		});
		
		thread.start();
		
	}

}
