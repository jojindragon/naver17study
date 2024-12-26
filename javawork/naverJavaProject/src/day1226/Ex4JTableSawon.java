package day1226;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex4JTableSawon extends JFrame {
	JTable table;
	List<Sawon> sawonList = new Vector<Sawon>();
	static final String SAWONFILENAME = "./src/day1226/mySawon.txt";

	public Ex4JTableSawon() {
		super("사원파일 읽기");
		this.setBounds(300, 100, 400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		this.sawonFileRead(); // 파일정보 읽어오기

		String[] title = { "사원명", "나이", "핸드폰", "주소" };
		String[][] data = new String[sawonList.size()][4];

		int i = 0;
		for (Sawon s : sawonList) {
			data[i][0] = s.getSawonName();
			data[i][1] = String.valueOf(s.getAge());
			data[i][2] = s.getHp();
			data[i][3] = s.getAddr();
			i++;
		}

		table = new JTable(data, title);

		this.add("North", new JLabel("사원 목록", JLabel.CENTER));
		this.add("Center", new JScrollPane(table));

	}

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

	public static void main(String[] args) {
		// 생성자 호출
		new Ex4JTableSawon();
	}

}
