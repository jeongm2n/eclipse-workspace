package exam01;

public abstract class Car {

	private Point point;
	private int speed;
	protected double distance;
	
	public Car() {}
	
	public Car(Point point, int speed) {
		this.point = point;
		this.speed = speed;
	}
	
	public abstract void run(int hour);
	public abstract double calcToll();
	public abstract void print();
	
	public static void printTitle() {
		System.out.println("차종\tspeed\tdistance\tx좌표\ty좌표\t요금");
	}

	public int getPointX() {
		return point.getX();
	}
	
	public int getPointY() {
		return point.getY();
	}

	public int getSpeed() {
		return speed;
	}
	
}
