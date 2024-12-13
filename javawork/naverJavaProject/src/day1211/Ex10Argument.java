package day1211;

public class Ex10Argument {

	public static void main(String[] args) {
		// double 형 인자값 읽기
		// 3과목 점수를 double로 읽어서 총점과 평균 구하기
		double score1 = Double.parseDouble(args[0]); // String을 double로 변환
		double score2 = Double.parseDouble(args[1]);
		double score3 = Double.parseDouble(args[2]);
		double total = score1+score2+score3;
		double avg = total/3;
		
		
		System.out.printf("점수 1\t: %5.3f점\n", score1);
		System.out.printf("점수 2\t: %5.3f점\n", score2);
		System.out.printf("점수 3\t: %5.3f점\n", score3);
		System.out.printf("총점\t: %6.1f점\n", total);
		System.out.printf("평균\t: %6.1f점\n", avg);

	}

}
