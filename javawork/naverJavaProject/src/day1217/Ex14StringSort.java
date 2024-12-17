package day1217;

public class Ex14StringSort {

	public static void main(String[] args) {
		// 문자열 정렬 - A.compareTo(B) 이용 A<B -1 / A==B 0 / A>B +
		String[] name = { "박남정", "공효진", "김미나", "이진", "손석구", "Adams" };
		for (int i = 0; i < name.length; i++) {
			for (int j = i + 1; j < name.length; j++) {
				if (name[i].compareTo(name[j]) > 0) {
					String temp = name[i];
					name[i] = name[j];
					name[j] = temp;
				}
			}
		}

		System.out.println("==정렬된 문자열==");
		for (String s : name)
			System.out.println(s);

	}

}
