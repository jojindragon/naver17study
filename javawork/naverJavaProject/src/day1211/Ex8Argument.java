package day1211;

public class Ex8Argument {

	public static void main(String[] args) {
		// 외부 값 읽어오기
		String name = args[0];
		String area = args[1];
		int year = Integer.parseInt(args[2]);
		int age = 2024 - year;
		
		int kor = Integer.parseInt(args[3]);
		int eng = Integer.parseInt(args[4]);
		double avg = (double)(kor+eng) / 2;
				
		
		System.out.println("이름 : "+name);
		System.out.println("연고 : "+area);
		System.out.println("탄생년 : "+year+", 나이  : "+age);
		System.out.println("======");
		System.out.println("국어 점수: "+kor+", 영어 점수: "+eng);
		System.out.println("총점: "+(kor+eng)+", 평균 점수: "+avg);
		
	}
}
