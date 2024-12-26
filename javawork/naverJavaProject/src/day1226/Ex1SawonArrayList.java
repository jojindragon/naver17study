package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex1SawonArrayList {
	List<Sawon> sawonList = new Vector<Sawon>();
	static final String SAWONFILENAME = "./src/day1226/mySawon.txt";

	public Ex1SawonArrayList() {
		// 생성 시 파일 불러오기
		this.sawonFileRead();
	}

	// 파일에서 읽어서 List에 넣기
	public void sawonFileRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(SAWONFILENAME);
			br = new BufferedReader(fr);

			while (true) {
				String sawonInfo = br.readLine();
				if (sawonInfo == null)
					break;

				String[] s = sawonInfo.split("\\|");
				Sawon sawon = new Sawon();
				sawon.setSawonName(s[0]);
				sawon.setAge(Integer.parseInt(s[1]));
				sawon.setHp(s[2]);
				sawon.setAddr(s[3]);

				// list에 추가
				sawonList.add(sawon);
			}

			System.out.println("총 " + sawonList.size() + "명 읽음");

		} catch (FileNotFoundException e) {
			System.out.println("저장된 사원 정보가 없다.");
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
	}

	// 파일 저장 - list 정보 파일에 저장
	public void sawonFileSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(SAWONFILENAME);
			for (Sawon sawon : sawonList) {
				String s = sawon.getSawonName() + "|" + sawon.getAge() + "|" + sawon.getHp() + "|" + sawon.getAddr()
						+ "\n";
				fw.write(s);
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

	// 사원 추가 - list에 추가
	public void addSawon(Sawon sawon) {
		sawonList.add(sawon);
		System.out.println(sawon.getSawonName() + "님 정보를 추가!");
	}

	// 이름에 따라 인덱스 반환
	public int getSearchName(String name) {
		int idx = -1;
		for (int i = 0; i < sawonList.size(); i++) {
			Sawon sawon = sawonList.get(i);
			if (sawon.getSawonName().equals(name)) {
				idx = i;
				break;
			}
		}
		return idx;
	}

	// 사원 삭제
	public void deleteSawon(String name) {
		int idx = this.getSearchName(name);
		if (idx == -1)
			System.out.println(name + " 사원은 존재하지 않는다.");
		else {
			System.out.println(name + " 사원 퇴출");
			sawonList.remove(idx);
		}
	}

	// 사원 검색
	public void searchSawon(String name) {
		int idx = getSearchName(name);
		if (idx == -1)
			System.out.println(name + " 님은 사원명단에 없다.");
		else {
			Sawon sawon = sawonList.get(idx);
			System.out.println("** " + name + "의 개인정보 **");
			System.out.println("나이: " + sawon.getAge() + "세");
			System.out.println("핸드폰: " + sawon.getHp());
			System.out.println("주소: " + sawon.getAddr());
		}
	}

	// 사원목록 출력
	public void printSawonList() {
		System.out.println("\t\t[전체 사원 정보]\n");
		System.out.println("번호\t사원명\t나이\t핸드폰\t\t주소");
		System.out.println("=".repeat(55));

		int n = 0;
		for (Sawon s : sawonList) {
			System.out.println(
					++n + "\t" + s.getSawonName() + "\t" + s.getAge() + "세\t" + s.getHp() + "\t" + s.getAddr());
		}

	}

	public static void main(String[] args) {
		Ex1SawonArrayList ex1 = new Ex1SawonArrayList();
		Scanner sc = new Scanner(System.in);
		int menu = 0;

		while (true) {
			System.out.println("** 사원 관리 메뉴 **");
			System.out.println("1. 사원정보 추가");
			System.out.println("2. 사원정보 검색");
			System.out.println("3. 사원삭제");
			System.out.println("4. 전체사원 출력");
			System.out.println("5. 저장 후 종료");
			System.out.print("번호 입력: ");

			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				menu = 4;
			}

			switch (menu) {
			case 1 -> { // 사원추가
				System.out.print("사원명: ");
				String name = sc.nextLine();
				System.out.print("나이: ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.print("핸드폰: ");
				String hp = sc.nextLine();
				System.out.print("주소: ");
				String addr = sc.nextLine();

				Sawon sawon = new Sawon(name, age, hp, addr);
				ex1.addSawon(sawon);
			}
			case 2 -> { // 사원 검색
				System.out.print("검색할 사원: ");
				String name = sc.nextLine();
				ex1.searchSawon(name);
			}
			case 3 -> { // 사원 삭제
				System.out.print("삭제할 사원: ");
				String name = sc.nextLine();
				ex1.deleteSawon(name);
			}
			case 4 -> { // 전체사원 출력
				ex1.printSawonList();
			}
			default -> { // 저장&종료
				ex1.sawonFileSave();
				System.out.println("사원정보를 파일에 저장후 종료합니다.");
				System.exit(0);
			}
			}

			System.out.println("-".repeat(40));
		}

	}

}
