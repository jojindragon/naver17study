package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex11FileList {
	static final String FILENAME = "./src/day1224/sawon.txt";

	List<String> sawonList = new Vector<String>();

	public Ex11FileList() {
		// 파일에서 이름을 읽고 sawonList에 추가
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			while (true) {
				String s = br.readLine();

				if (s == null)
					break;
				else
					sawonList.add(s);
			}

		} catch (FileNotFoundException e) {
			System.out.println("Not Found File: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException | NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("** 리스트에 내용 추가 완료 **");

	}

	public void sawonMemberList() {
		// 사원 이름을 번호와 함꼐 출력
		System.out.println("** 사원 이름 **");
		for (int i = 0; i < sawonList.size(); i++)
			System.out.println(i + 1 + "번: " + sawonList.get(i));

	}

	public int getSearchName(String name) {
		// 해당 이름이 몇번 인덱스에 있는지 리턴, -1: 없음
		int idx = -1;
		for (int i = 0; i < sawonList.size(); i++) {
			String listName = sawonList.get(i);
			if (listName.equals(name)) {
				idx = i;
				break;
			}
		}

		return idx;
	}

	public void deleteSawon(String name) {
		// 입력한 이름 삭제
		int idx = getSearchName(name);
		if (idx == -1)
			System.out.println(name + "님은 존재하지 않는다.");
		else {
			sawonList.remove(idx);
			System.out.println(name + "님을 퇴출했다.");
		}

	}

	public void serachName(String name) {
		// 이름 조회
		int idx = getSearchName(name);
		if (idx == -1)
			System.out.println(name + "님은 존재하지 않는다.");
		else {
			System.out.println(name + "님은 " + (idx + 1) + "번째 명단에 존재한다.");
		}
	}

	public void sawonFileSave() {
		// List 이름들을 다시 파일에 저장
		FileWriter fw = null;

		try {
			fw = new FileWriter(FILENAME);
			for (String s : sawonList) {
				fw.write(s + "\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addSawon(String name) {
		// 사원명 추가 - 이미 존재하는 이름이면 추가 X
		int idx = this.getSearchName(name);
		if (idx != -1)
			System.out.println(name + "님은 이미 있다.");
		else {
			sawonList.add(name);
			System.out.println("추가 완료");
		}

	}

	public static void main(String[] args) {
		Ex11FileList ex11 = new Ex11FileList();
		Scanner sc = new Scanner(System.in);
		int menu = 0;

		while (true) {
			System.out.println("1.사원추가  2.사원삭제  3.사원검색  4.전체목록  5.저장후종료");
			System.out.println("=".repeat(40));

			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				menu = 4;
			}

			switch (menu) {
			case 1 -> {
				System.out.print("추가할 사원명 입력: ");
				String name = sc.nextLine();
				ex11.addSawon(name);
			}
			case 2 -> {
				System.out.print("삭제할 사원명 입력: ");
				String name = sc.nextLine();
				ex11.deleteSawon(name);
			}
			case 3 -> {
				System.out.print("검색할 사원명 입력: ");
				String name = sc.nextLine();
				ex11.serachName(name);
			}
			case 4 -> ex11.sawonMemberList();
			default -> {
				System.out.println("** 저장 후 종료 **");
				ex11.sawonFileSave();
				System.exit(0);
			}
			}
		}

	}

}
