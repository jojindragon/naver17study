package day1223;
/*jdk8에서 추가된 기능 - 디폴트 인스턴스 메소드로 기능 구현 가능*/

interface RemoteControl {
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	public void turnOn();

	public void turnOff();

	public void setVolume(int volume);

	default void setMute(boolean mute) { // 인터페이스에서 구현
		if (mute) {
			System.out.println("무음 처리");
			setVolume(MIN_VOLUME);
		} else {
			System.out.println("무음 해제");
		}
	}
}

class Television implements RemoteControl {
	int volume;

	@Override
	public void turnOn() {
		System.out.println("Tv ON");

	}

	@Override
	public void turnOff() {
		System.out.println("Tv OFF");

	}

	@Override
	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println("현재 볼륨: " + this.volume);

	}

}

public class Ex5DefaultInterface {

	public static void main(String[] args) {
		RemoteControl rc1 = null; // 인터페이스 - new 생성 불가
//		rc1.setMute(false); // null 포인트 익셉션 발생

		rc1 = new Television();
		rc1.turnOn();
		rc1.turnOff();
		// 인터페이스에서 구현된 것도 상속받은 클래스로만 호출 가능
		rc1.setMute(false);
		rc1.setMute(true);

	}

}
