package privateTest;

import java.io.IOException;
import java.util.Calendar;

public class Cloack {

	private static String formatDate(Calendar c) { // 날짜 출력용
		Integer year = c.get(Calendar.YEAR);
		Integer month = c.get(Calendar.MONTH) + 1; // 0~11
		Integer day = c.get(Calendar.DAY_OF_MONTH);
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK); // 1~7

		String[] dowStr = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		String dow = dowStr[dayOfWeek - 1];

		return year + "/" + month + "/" + day + "(" + dow + ")";
	}

	public static void main(String[] args) {
		// 일정 주기로 보여지는 시계
		Calendar c = Calendar.getInstance();
		Integer prevYear = c.get(Calendar.YEAR); // 비교용
		Integer prevMonth = c.get(Calendar.MONTH);
		Integer prevDay = c.get(Calendar.DAY_OF_MONTH);
		Integer prevDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		// 처음 날짜 출력
		System.out.println("현재 날짜: " + formatDate(c));

		while (true) {
			Calendar newC = Calendar.getInstance(); // 정보 새로 업데이트
			Integer curYear = newC.get(Calendar.YEAR);
			Integer curMonth = newC.get(Calendar.MONTH);
			Integer curDay = newC.get(Calendar.DAY_OF_MONTH);
			Integer curDayOfWeek = newC.get(Calendar.DAY_OF_WEEK);

			Integer hour = newC.get(Calendar.HOUR_OF_DAY);
			Integer minute = newC.get(Calendar.MINUTE);
			Integer sec = newC.get(Calendar.SECOND);

			// 사용자 입력으로 종료
			Thread input = new Thread(() -> {
				try {
					System.in.read();
					System.out.println("프로그램 종료");
					System.exit(0);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			input.start(); // 입력 쓰레드

			// 시간 출력
			System.out.println("현재 시간: " + hour + ":" + minute + ":" + sec);

			// 날짜 확인
			if (curYear == prevYear || curMonth != prevMonth || curDay != prevDay) {
				prevYear = curYear;
				prevMonth = curMonth;
				prevDay = curDay;
				prevDayOfWeek = curDayOfWeek;
				System.out.println("현재 날짜: " + formatDate(newC));
			}

			// 출력 주기
			try {
				Thread.sleep(1000); // 30초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
