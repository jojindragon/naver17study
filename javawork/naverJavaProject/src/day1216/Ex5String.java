package day1216;

public class Ex5String {

	public static void main(String[] args) {
		// String 클래스 멤버 메서드에 대해
		String str1 = "Apple";
		String str2 = "Happy Happy Happy Day!";
		String str3 = "Orange";

		System.out.println("str1 = " + str1);
		System.out.println("str2 = " + str2);
		System.out.println("str3 = " + str3);
		System.out.println("str2의 길이: " + str2.length()); // 공백 포함 길이

		System.out.println("str1의 첫번째 단어: " + str1.charAt(0));
		System.out.println("str2의 두번째 단어: " + str1.charAt(1));
		System.out.println("str3의 네번째 단어: " + str1.charAt(3)); // 반대되는 개념 - IndexOf()
		System.out.println();

		System.out.println("str1에서 l의 위치: " + str1.indexOf('l')); // 반대되는 개념 - charAt()
		System.out.println("str2에서 a의 위치: " + str2.indexOf('a'));
		System.out.println("str2에서 마지막 a의 위치: " + str2.lastIndexOf('a')); // - 같은 문자 중 마지막 위치
		System.out.println("str3에서 x의 위치: " + str2.indexOf('x')); // 없는 경우: 반환값 -1
		System.out.println();

		// 비교 관련
		String str4 = new String("Apple");
		System.out.println(str1 == str4); // == 동등 연산자 - 주소를 비교하는 연산자, 내부적으로 주소가 달라 false
		System.out.println(str3 == "Apple");
		System.out.println(str3 == "Orange");
		System.out.println(str1 == "apple");

		System.out.println(str1.equals(str4)); // 정확한 비교 - 대소문자 포함
		System.out.println(str1.equals("apple"));
		System.out.println(str1.equalsIgnoreCase(str4)); // 대소문자 무시하고 비교
		System.out.println(str1.equalsIgnoreCase("apple"));
		System.out.println();

		// 문자열 비교 - 배열 관련 (정렬 등에 씀)
		System.out.println("문자열 비교: compareTo()");
		int n = str1.compareTo("Apple");
		System.out.println(n); // 대소문자까지 같을 경우 - 0

		n = str1.compareTo("Banana");
		System.out.println(n); // 문자열 1이 문자열 2보다 작을 경우 -1: A하고 B의 비교

		n = str3.compareTo(str1);
		System.out.println(n); // 14 - 알파벳 순서가 역으로 됐을 떄 양수 값 - 차이가 14 A(65)와 O(79)
		System.out.println();

		// 대소문자 변화
		System.out.println("모두 대문자로: " + str2.toUpperCase());
		System.out.println("모두 소문자로: " + str2.toLowerCase());
		System.out.println();

		// OOO로 시작하면 true
		System.out.println("Have로 시작? " + str2.startsWith("Have"));
		System.out.println("Happy로 시작? " + str2.startsWith("Happy"));
		System.out.println();

		// OOO로 끝나면 true
		System.out.println("Day!로 끝나면? " + str2.endsWith("Day"));
		System.out.println("Day로 끝나면? " + str2.endsWith("Day!"));
		System.out.println();

		// 문자열 반복 출력
		System.out.println("-".repeat(50));
		System.out.println(str1.repeat(5));
		System.out.println("*".repeat(30));
		System.out.println();

		// 교체해서 출력
		System.out.println(str2.replace("a", "*"));
		System.out.println(str2.replace("Happy", "Nice"));
		System.out.println();

		// index n번부터 출력
		System.out.println(str2.substring(7)); // index 7~끝
		System.out.println(str2.substring(7, 10)); // index 7~9
		System.out.println();

		// split - 분리
		String str5 = "red,green,blue,yellow,gray,black";
		String[] array = str5.split(",");
		for (String a : array)
			System.out.print(a + " ");
		System.out.println();

		// 앞뒤 공백 제거 반환
		String str6 = "    Hello    ";
		System.out.println(str6);
		System.out.println("*" + str6.trim() + "*");
		System.out.println();

		// String 타입으로 변환 - valueOf()
		String s1 = 100 + "";
		String s2 = String.valueOf(true);
		String s3 = String.valueOf(34.6);
		String s4 = String.valueOf('A');

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

	}

}
