package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Ex6TableCRUD extends JFrame {
	List<Student> list = new Vector<Student>();
	static final String StuFILENAME = "./src/day1226/student.txt";
	JTable table;

	DefaultTableModel tableModel; // 추가&삭제 등의 메소드를 갖고있는 클래스모델
	JTextField tfName, tfKor, tfEng;
	JButton addBtn;

	public Ex6TableCRUD() {
		super("학생성적 관리");
		this.setBounds(300, 100, 500, 300);

		this.initDesign();
		this.setVisible(true);

		// 윈도우 x버튼 클릭 시 이벤트를 발생시켜서 파일 저장
		// 익명 내부클래스 형태로 이벤트 구현
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// list 내용을 파일에 저장
				saveFile();
				System.exit(0);
				super.windowClosing(e);
			}
		});
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

				String[] data = stuInfo.split("\\|");
				Student stu = new Student();
				stu.setName(data[0]);
				stu.setKor(Integer.parseInt(data[1]));
				stu.setEng(Integer.parseInt(data[2]));

				list.add(stu);
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
		this.studentFileRead();

		String[] title = { "이름", "국어", "영어", "총점", "평균" };
		tableModel = new DefaultTableModel(title, 0); // 행갯수: 0 설정
		table = new JTable(tableModel);

		// 테이블 데이터 추가
		this.displayStudents();

		// frame에 추가
		this.add("North", new JLabel("학생 성적", JLabel.CENTER));
		this.add("Center", new JScrollPane(table));

		// 입력부분
		JPanel panel = new JPanel();
		tfName = new JTextField(5);
		tfKor = new JTextField(4);
		tfEng = new JTextField(4);

		addBtn = new JButton("추가");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력한 데이터를 읽어서 넣은 후 다시 list에 추가
				String name = tfName.getText();
				int kor = Integer.parseInt(tfKor.getText());
				int eng = Integer.parseInt(tfEng.getText());

				Student student = new Student(name, kor, eng);
				list.add(student);

				displayStudents();

				// 입력 필드 초기화
				tfName.setText("");
				tfKor.setText("");
				tfEng.setText("");
			}
		});

		panel.add(new JLabel("이름"));
		panel.add(tfName);
		panel.add(new JLabel("국어"));
		panel.add(tfKor);
		panel.add(new JLabel("영어"));
		panel.add(tfEng);
		panel.add(addBtn);

		this.add("North", panel);

	}

	// 데이터 테이블 표시
	public void displayStudents() {
		tableModel.setRowCount(0); // 테이블 초기화 후 다시 추가

		for (Student stu : list) {
			Vector<String> data = new Vector<String>();

			int kor = stu.getKor();
			int eng = stu.getKor();
			int sum = kor + eng;
			double avg = sum / 2.0;

			data.add(stu.getName());
			data.add(String.valueOf(kor));
			data.add(String.valueOf(eng));
			data.add(String.valueOf(sum));
			data.add(String.valueOf(avg));

			tableModel.addRow(data);

//			int sum = stu.getKor() + stu.getEng();
//			double avg = sum / 2.0;
//			Object[] row = { stu.getName(), stu.getKor(), stu.getEng(), sum, avg };
//			tableModel.addRow(row);
		}
	}

	public void saveFile() { // List 내용 파일에 저장
		FileWriter fw = null;

		try {
			fw = new FileWriter(StuFILENAME);

			for (Student stu : list) {
				String s = stu.getName() + "|" + stu.getKor() + "|" + stu.getEng() + "\n";
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

	public static void main(String[] args) {
		new Ex6TableCRUD();
	}

}
