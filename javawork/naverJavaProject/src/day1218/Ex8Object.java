package day1218;

class Orange {
	public static final String MESSAGE = "Happy";

	private String name;
	private int age;

	public void showData() {
		// 일반 멤버 메서드: this 라는 인스턴스 변수 소유
		// static 멤버 메서드: this X
		// this.---로 접근 (경우에 따라 생략 가능)
		System.out.println("이름: " + name + ", 나이: " + age);
	}

	// 값 변경을 위한 setter method
	public void setName(String name) {
		// 같은 구역에 멤버 변수와 동일 이름의 변수가 있으므로 this 필수
		this.name = name;
	}

	public void setAge(int age) {
		// this가 멤버변수
		this.age = age;
	}

}

public class Ex8Object {

	public static void main(String[] args) {
		System.out.println(Orange.MESSAGE);

		// private 이라 직접접근 불가 <- Orange의 메서드가 필요(getter, setter)
		Orange o = new Orange();
//		System.out.println(o.name); <- 오류발생
		o.showData();
		
		System.out.println("Value Change");
		o.setName("dragon");
		o.setAge(5000);
		o.showData();
	}

}
