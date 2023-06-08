package date0504;

public class Grade {
	
	public Grade(int point) {
		switch(point){
			case 10 : 
				System.out.println("성적 : A");
				break;
			case 9 :
				System.out.println("성적 : B");
				break;
			case 8 : 
				System.out.println("성적 : C");
				break;
			case 7 :
				System.out.println("성적 : D");
				break;
			default :
				System.out.println("성적 : F");
				break;
		}
	}
}
