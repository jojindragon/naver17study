package day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
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

	public static void main(String[] args) {
		Ex11FileList ex11 = new Ex11FileList();
		ex11.sawonMemberList();

	}

}
