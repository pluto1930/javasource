package transportation;

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();	// �ڵ� ����ȯ, �������̽��� busŬ������ ����
		
		vehicle.run();		// Vehicle ���� -> Bus ����
		vehicle.electCharge();		// ������ electCharge
		
		vehicle = new Texi();
		vehicle.run();
		vehicle.electCharge();		// �ý��� electCharge
		
		vehicle = new Airplain();
		vehicle.run();
		vehicle.electCharge();		// ������� electCharge
		
		if(vehicle instanceof Bus) {
			System.out.println("��ȯ ����");
			Bus bus = (Bus) vehicle;		// ���� ����ȯ
			bus.run();
			bus.checkFare();
		}

	}
}
