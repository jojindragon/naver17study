package day1220;

class SuperObj2 {
	private String schoolName;

	public SuperObj2() {
		schoolName = "OOO School";
	}

	SuperObj2(String schoolName) {
		this.schoolName = schoolName;
	}

	public void write() {
		System.out.println("학교명: " + schoolName);
	}
}

class SubObj2 extends SuperObj2 {
	private String studentName;

	public SubObj2() {
		studentName = "이름 없음";
	}

	SubObj2(String schoolName, String studentName) {
		super(schoolName); // 이렇게 부모로 값 전달
		this.studentName = studentName;
	}

	@Override // 부모의 메소드를 재정의 했다는 의미 - Annotation
	public void write() {
		super.write(); // 부모가 처리한 로직 처리 실행 - 호출 위치 무관
		System.out.println("학생 이름: " + studentName);
		System.out.println();
	}
}

class SubObj22 extends SuperObj2 {
	private String teacherName;

	public SubObj22() {
		teacherName = "이름 X";
	}

	SubObj22(String schoolName, String teacherName) {
		super(schoolName);
		this.teacherName = teacherName;
	}

	@Override
	public void write() {
		System.out.println("선생 이름: " + teacherName);
		super.write();
		System.out.println();
	}
}

public class Ex2Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj2 s1 = new SubObj2();
		SubObj2 s2 = new SubObj2("강남 고등학교", "홍길동");
		SubObj22 s3 = new SubObj22("비트캠프", "aaa");
		SubObj22 s4 = new SubObj22("중동 고등학교", "이진");

		s1.write();
		s2.write();
		s3.write();
		s4.write();
	}

}
