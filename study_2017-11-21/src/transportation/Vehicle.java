package transportation;

public interface Vehicle {
	// �ʼ� ��� [static final] ���� ����
	
	// �߻� �޼���[abtstract] ���� ����
	public abstract void run();
	
	// �⺻ �޼���, update
	default void electCharge() {
		System.out.println("�������Դϴ�.");
	}
}
