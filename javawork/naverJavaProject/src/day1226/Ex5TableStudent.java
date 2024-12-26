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

public class Ex5TableStudent extends JFrame {
	JTable table;
	List<Student> list = new Vector<Student>();
	static final String StuFILENAME = "./src/day1226/student.txt";

	public Ex5TableStudent() {
		super("학생성적 관리");
		this.setBounds(300, 100, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.initDesign();
		this.setVisible(true);
	}

	public void studentFileRead() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(StuFILENAME);
			br = new BufferedReader(fr);

			while (true) {
				String stuInfo = br.readLine();
				if (stuInfo == null)
					break;

				String[] s = stuInfo.split("\\|");
				Student student = new Student();
				student.setName(s[0]);
				student.setKor(Integer.parseInt(s[1]));
				student.setEng(Integer.parseInt(s[2]));

				list.add(student);
			}

			System.out.println("총 " + list.size() + "명 읽음");
		} catch (FileNotFoundException e) {
			System.out.println("저장된 학생 정보가 없다.");
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

	public void initDesign() {
		// 제목: 이름, 국어, 영어, 총점, 평균 출력
		this.studentFileRead();

		String[] title = { "이름", "국어", "영어", "총점", "평균" };
		String[][] data = new String[list.size()][5];

		int i = 0;
		for (Student s : list) {
			data[i][0] = s.getName();
			data[i][1] = String.valueOf(s.getKor());
			data[i][2] = String.valueOf(s.getEng());

			int sum = s.getKor() + s.getEng();
			double avg = (double) sum / 2;

			data[i][3] = String.valueOf(sum);
			data[i][4] = String.valueOf(avg);

			i++;
		}

		table = new JTable(data, title);

		this.add("North", new JLabel("학생 성적", JLabel.CENTER));
		this.add("Center", new JScrollPane(table));

	}

	public static void main(String[] args) {
		new Ex5TableStudent();

	}

}
