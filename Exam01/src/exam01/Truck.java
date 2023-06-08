package exam01;

public class Truck extends Car{
	
	int weight = 0;
	
	public Truck() {}
	
	public Truck(Point point, int speed) {
		super(point,speed);
	}
	
	@Override
	public void run(int hour) {
		// TODO Auto-generated method stub
		distance = (hour * getSpeed()) * 0.7 ;
	}

	@Override
	public double calcToll() {
		// TODO Auto-generated method stub
		double result = (weight * 0.12) * distance;
		return result;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		//System.out.println("차종\tspeed\tdistance\tx좌표\ty좌표\t요금");
		System.out.print("트럭\t" + getSpeed() + "\t");
		System.out.printf("%.1f\t\t", distance);
		System.out.print(getPointX() + "\t" + getPointY() + "\t");
		System.out.printf("%.1f\n", calcToll());
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
