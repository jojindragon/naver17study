package day1217;

public class Ex9ArrayAge {

	public static void main(String[] args) {
		// data[]를 분석해서 10~50대까지의 각각의 인원수를 구해라. - age[]
		int[] data = { 12, 34, 53, 22, 21, 21, 10, 19, 27, 48 };
		int[] age = new int[5];

		for (int i = 0; i < data.length; i++) {
			int pivot = (data[i] / 10 <= 4 && data[i] / 10 >= 1) ?
					data[i] / 10 - 1 : 4;
			
			age[pivot]++;
		}

		System.out.println("== 데이터 연령 분석 ==");
		for (int i = 0; i < 4; i++) {
			System.out.println((i + 1) * 10 + "대: " + age[i] + "명");
		}
		System.out.println("10대 미만 50대 이상: " + age[4] + "명");

	}

}
