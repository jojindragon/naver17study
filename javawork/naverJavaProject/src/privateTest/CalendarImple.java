package privateTest;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarImple {

	private static Calendar c = Calendar.getInstance();

	public static void printCalendar() {
		Calendar temp = (Calendar) c.clone();
		temp.set(Calendar.DAY_OF_MONTH, 1);

		int firstDay = temp.get(Calendar.DAY_OF_WEEK);
		int daysInMonth = temp.getActualMaximum(Calendar.DAY_OF_MONTH);

		Calendar prevMonth = (Calendar) temp.clone();
		prevMonth.add(Calendar.DAY_OF_MONTH, -1);
		int daysInPrevMonth = prevMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		System.out.printf("\n   === \t\t%d년 %d월\t\t ===\n", year, month);

		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("=".repeat(50));

		for (int i = 1; i < firstDay; i++) {
			System.out.printf("%2d\t", daysInPrevMonth - firstDay + i + 1);
		}

		for (int i = 1; i <= daysInMonth; i++) {
			System.out.printf("%2d\t", i);
			if ((i + firstDay - 1) % 7 == 0)
				System.out.println();
		}

		for (int i = 1; (i + daysInMonth + firstDay - 1) % 7 != 0; i++) {
			System.out.printf("%2d\t", i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 반응형 달력
		Scanner sc = new Scanner(System.in);
		while (true) {
			printCalendar();
			System.out.println("'<'\t\t\t'q'\t\t\t'>'");
			System.out.print("Enter: ");
			String input = sc.nextLine();
			if (input.equals("<"))
				c.add(Calendar.MONTH, -1);
			else if (input.equals(">"))
				c.add(Calendar.MONTH, 1);
			else if (input.equals("q"))
				break;
		}
		sc.close();

	}

}
