package exam01;

public class Taxi extends Car{
	
	int taxifare = 0;
	
	public Taxi() {}
	
	public Taxi(Point point, int speed) {
		super(point,speed);
	}
	
	@Override
	public void run(int hour) {
		// TODO Auto-generated method stub
		distance = hour * getSpeed(); 
	}

	@Override
	public double calcToll() {
		// TODO Auto-generated method stub
		double result = (taxifare * 0.023) * distance;
		return result;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		//System.out.println("차종\tspeed\tdistance\tx좌표\ty좌표\t요금");
		System.out.print("택시\t" + getSpeed() + "\t");
		System.out.printf("%.1f\t\t", distance);
		System.out.print(getPointX() + "\t" + getPointY() + "\t");
		System.out.printf("%.1f\n", calcToll());
	}

	public void setTaxifare(int taxifare) {
		this.taxifare = taxifare;
	}
	
}
