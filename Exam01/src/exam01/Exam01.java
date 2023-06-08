package exam01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Point pnt1 = new Point(7,5); //Taxi의 좌표 
		Point pnt2 = new Point(10,12); //Truck의 좌표 
		
		ArrayList<Car> cars = new ArrayList<>();
		
		Taxi taxi = new Taxi(pnt1,100); //Taxi 객체 생성 
		Truck truck = new Truck(pnt2,80); //Truck 객체 생성 
		
		taxi.setTaxifare(1900);
		truck.setWeight(2000);
		
		System.out.print("택시의 운행시간 >> ");
		int a = sc.nextInt();
		System.out.print("트럭의 운행시간 >> ");
		int b = sc.nextInt();
		
		taxi.run(a);
		truck.run(b);
		
		cars.add(taxi);
		cars.add(truck);
		
		taxi.printTitle();
		
		for(Car car : cars) {
			car.print();
		}
	}
}
