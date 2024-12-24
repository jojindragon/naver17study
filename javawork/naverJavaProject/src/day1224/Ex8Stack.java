package day1224;

import java.util.Stack;

public class Ex8Stack {

	public static void main(String[] args) {
		// LIFO(Last-In-First-Out): 마지막으로 들어간 데이터가 먼저 나옴
		// push, pop으로 추가 제거
		// 증복 허용

		Stack<String> stack1 = new Stack<String>();

		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("사과");
		stack1.push("키위");
		stack1.push("딸기");

		System.out.println("stack 갯수: " + stack1.size());
		while (!stack1.isEmpty()) {
			System.out.println(stack1.pop());
		}

	}

}
