package day1224;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex7Map {

	public static void main(String[] args) {
		// Map의 타입: key, value의 쌍으로 데이터 추가
		// 이때 key 값은 Set 타입 - 즉, 중복 비허용(덮어쓴다) + 비순차적
		Map<String, String> map = new HashMap<String, String>();

		// map 데이터 추가
		map.put("name", "송혜교");
		map.put("age", "34");
		map.put("blood", "AB");
		map.put("name", "이영자");

		System.out.println("Map 사이즈: " + map.size());
		System.out.println("Map에서 key 값으로 value 값 꺼내기");
		System.out.println("이름: " + map.get("name"));
		System.out.println("나이: " + map.get("age"));
		System.out.println("혈액형: " + map.get("blood"));
		System.out.println("핸드폰: " + map.get("hp")); // 없는 경우 null 값 반환
		System.out.println();

		System.out.println("key 값을 자동으로 얻고 value 값 꺼내기");
		Set<String> keySets = map.keySet();
		for (String key : keySets) {
			String v = map.get(key);
			System.out.println(key + " => " + v);
		}

	}

}
