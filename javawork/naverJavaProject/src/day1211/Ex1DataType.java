package day1211;

public class Ex1DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 127;
		byte b = (byte)128; // 강제 형 변환 - cast 연산자
		byte c = (byte)200; 
		
		System.out.println("a="+a);
		// 범위 밖이므로 틀린 값 나옴 - 정확히는 2의 보수 값
		System.out.println("b="+b); // -128 
		System.out.println("c="+c); // -56
	}

}
