package transportation;

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();	// 자동 형변환, 인터페이스가 bus클래스를 참조
		
		vehicle.run();		// Vehicle 선언 -> Bus 구현
		vehicle.electCharge();		// 버스의 electCharge
		
		vehicle = new Texi();
		vehicle.run();
		vehicle.electCharge();		// 택시의 electCharge
		
		vehicle = new Airplain();
		vehicle.run();
		vehicle.electCharge();		// 비행기의 electCharge
		
		if(vehicle instanceof Bus) {
			System.out.println("변환 가능");
			Bus bus = (Bus) vehicle;		// 강제 형변환
			bus.run();
			bus.checkFare();
		}

	}
}
