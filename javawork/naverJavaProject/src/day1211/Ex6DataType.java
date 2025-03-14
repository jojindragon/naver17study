package day1211;

public class Ex6DataType {

	public static void main(String[] args) {
		// String 은 기본형이 아닌 객체 타입
		String str1 = "Hello";
		String str2 = new String("Happy");
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println("\t"+str1);
		System.out.println("\t\t"+str2);
		
		System.out.printf("%s\n", str1);
		System.out.printf("%20s\n", str1);
		System.out.printf("**%-30s**\n", str1);
		
		// 문자열의 +: 나열을 의미
		System.out.println(str1+str2);
	}

}
