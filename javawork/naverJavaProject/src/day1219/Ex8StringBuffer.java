package day1219;

public class Ex8StringBuffer {

	public static void main(String[] args) {
		// String은 값 자체를 변경 불가 - 기존 문자 안 바꾸고 리턴
		String str = "Happy";

		StringBuffer sb = new StringBuffer(str);
		// 인스턴스 변수명만 출력 시 자동으로 toString() 호출
		// toString을 갖지 않은 경우 - 값이 아닌 주소 출력
		System.out.println(sb);
		System.out.println(sb.toString());

		// StringBuffer - 기존 문자열 편집 가능
		sb.append('A');
		sb.append(100);
		sb.append("Bitcamp");
		System.out.println(sb);

		sb.delete(5, 9); // 인덱스 5~8 삭제
		System.out.println(sb);

		sb.insert(3, "Java"); // 인덱스 3에 삽입 - 중간 삽입
		System.out.println(sb);

		// 중간 문자열 변경
		sb.replace(3, 7, "Hello"); // 3~6까지의 문자를 치환
		System.out.println(sb);

		// 데이터를 Json 데이터로 변환
		String name = "캔디";
		int age = 23;

		StringBuffer sb2 = new StringBuffer();
		sb2.append("{\"name\":");
		sb2.append("\"" + name + "\",");

		sb2.append("\"age\":");
		sb2.append(age + "}");

		System.out.println(sb2);

	}

}
