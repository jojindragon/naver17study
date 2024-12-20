package day1220;

import java.util.List;
import java.util.Vector;

public class Ex7Abstract {

	public static void main(String[] args) {
		// 다형성 처리 예
		List<String> list = null; // 부모
		list = new Vector<String>(); // 리스트를 구현한 상속

		list.add("Red"); // add - 오버라이드 메소드
		list.add("Green");
		for (String s : list)
			System.out.println(s);

		// 현재 할당된 크기를 알아보는 메소드 capacity() - Vector 만이 가짐
		int n = ((Vector<String>) list).capacity();
		System.out.println(n);

	}

}
