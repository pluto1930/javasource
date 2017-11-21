package transportation;

public interface Vehicle {
	// 필수 상수 [static final] 생략 가능
	
	// 추상 메서드[abtstract] 생략 가능
	public abstract void run();
	
	// 기본 메서드, update
	default void electCharge() {
		System.out.println("충전중입니다.");
	}
}
