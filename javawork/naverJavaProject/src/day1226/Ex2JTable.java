package day1226;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex2JTable extends JFrame {
	JTable table;

	public Ex2JTable() {
		super("JTable 공부");
		this.setBounds(300, 100, 300, 300); // 시작위치&크기 설정
		// 메모리 제거 자동
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true); // 프레임 보이게 하기
	}

	public void initDesign() {
		// 기본 레이아웃: BorderLayout - 동서남북센터로 위치를 정하는 레이아웃

		// 방법1
//		String[] title = { "이름", "혈액혈", "나이" };
//		String[][] data = { { "이미자", "AB", "23" }, { "손기자", "A", "34" }, { "박민영", "B", "19" } };

		// 방법2
		Vector<String> title = new Vector<String>();
		title.add("이름");
		title.add("혈액혈");
		title.add("나이");

		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> data1 = new Vector<String>();
		data1.add("박민영");
		data1.add("AB");
		data1.add("23");

		data.add(data1);

		// JTable 생성
		table = new JTable(data, title);

		this.add("North", new JLabel("데이터 출력 테이블", JLabel.CENTER));

		// frame center에 추가
//		this.add("Center", table); // 제목 X, 데이터가 많을수록 스크롤 X

		// JScrollPane - 스크롤, 제목 등 생성
		this.add("Center", new JScrollPane(table));

	}

	public static void main(String[] args) {
		Ex2JTable ex2 = new Ex2JTable();
	}

}
