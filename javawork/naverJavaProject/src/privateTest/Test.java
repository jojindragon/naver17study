package privateTest;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		// 개인 학습용
		Calendar today = Calendar.getInstance();

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int date = today.get(Calendar.DATE);
		System.out.println("금일(YYYY/MM/DD) : " + year + "/" + month + "/" + date);

		int woy = today.get(Calendar.WEEK_OF_YEAR);
		int wom = today.get(Calendar.WEEK_OF_MONTH);
		System.out.println("금년의 " + woy + "주차, 금월의 " + wom + "주차");

	}

}
