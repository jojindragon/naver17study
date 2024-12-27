package day1227;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MySawon {
	public void sawonAdd(String name);
}

@FunctionalInterface
interface Sales {
	public void sangpumAdd(String sangpum, int su, int dan);
}

public class Ex3Lambda {
	MySawon sawon = (name) -> System.out.println(name + " 사원 추가!");

	Sales sa = (sang, su, dan) -> {
		System.out.println(sang + " 상품 등록");
		System.out.println("수량:" + su + "개");
		System.out.println("단가:" + dan + "원");
		System.out.println("총금액:" + su * dan + "원");
		System.out.println("=".repeat(20));
	};

	public static void main(String[] args) {
		Ex3Lambda ex3 = new Ex3Lambda();
		ex3.sawon.sawonAdd("홍길동");
		ex3.sawon.sawonAdd("이영자");

		ex3.sa.sangpumAdd("딸기", 5, 9000);
		ex3.sa.sangpumAdd("오렌지", 3, 2000);

		System.out.println("List 데이터 람다식 출력");
		List<String> list = Arrays.asList("빨강", "노랑", "분홍", "초록", "검정");

		System.out.println("출력1");
		for (String s : list)
			System.out.print(s + " ");
		System.out.println();

		System.out.println("출력2");
		list.forEach(s -> System.out.print(s + " "));

	}

}
