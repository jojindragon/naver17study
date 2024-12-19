package day1219;

class Orange {
	private String name;
	private String color;
	private int age;

	// 생성자
	Orange() {
//		this.name = "초기값";
//		this.color = "red";
//		this.age = 30;

		// 생성자에서 다른 생성자 호출 시 this() 사용
		this("this 호출", "green");
	}

	Orange(String name, String color) {
		this.name = name;
		this.color = color;
		this.age = 30;
	}

	public void writeMember() {
		System.out.println("name: " + name);
		System.out.println("color: " + color);
		System.out.println("age: " + age);
	}

	public void writeMember(int n) { // 오버로딩
		if (n == 1) {
			System.out.println("이름: " + name);
			System.out.println("최애 색: " + color);
			System.out.println("나이: " + age);
			System.out.println("*".repeat(20));
		} else if (n == 2) {
			System.out.println(name + "님은 " + color + "색을 좋아한다.");
		} else {
			System.out.println("1 or 2만 가능");
		}
	}

}

public class Ex4Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange o1 = new Orange();
		o1.writeMember();

		Orange o2 = new Orange("고민시", "blue");
		o2.writeMember();
		o2.writeMember(1);
		o2.writeMember(2);
		o2.writeMember(3);
	}

}
