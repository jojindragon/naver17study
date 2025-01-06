package day0106db;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex2shopTable extends JFrame {
	JTextField tfSang, tfSu, tfDan;
	JButton addBtn, delBtn, updateBtn, searchBtn;
	DefaultTableModel tableModel;
	JTable table;

	// DB shop 테이블 관리할 클래스
	ShopModel shopModel = new ShopModel();

	public Ex2shopTable() {
		super("shop 관리");
		this.setBounds(300, 100, 600, 400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void initDesign() {
		JPanel p1 = new JPanel();
		tfSang = new JTextField(6);
		tfSu = new JTextField(3);
		tfDan = new JTextField(6);

		p1.add(new JLabel("상품명"));
		p1.add(tfSang);
		p1.add(new JLabel("수량"));
		p1.add(tfSu);
		p1.add(new JLabel("단가"));
		p1.add(tfDan);

		// p1 panel frame 상단에 추가
		this.add("North", p1);

		// frame 중간에 table 넣기
		String[] title = { "인덱스", "상품명", "수량", "단가", "총금액", "입고일" };
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table)); // 제목&스크롤

		// 생성된 테이블에 DB 데이터 추가
		this.rowSelect();

		// 하단 버튼 3개
		addBtn = new JButton("상품추가");
		delBtn = new JButton("상품삭제");
		updateBtn = new JButton("상품수정");
		searchBtn = new JButton("상품조회");

		JPanel p2 = new JPanel();
		p2.add(addBtn);
		p2.add(delBtn);
		p2.add(updateBtn);
		p2.add(searchBtn);
		this.add("South", p2);

		// 상품 추가 버튼 이벤트
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력한 데이터를 읽어서 dto로 묶기
				String sangpum = tfSang.getText();
				if (sangpum.length() == 0) {
					JOptionPane.showMessageDialog(Ex2shopTable.this, "상품명 입력해주세요.");
					return;
				}

				String textSu = tfSu.getText();
				int su = 0;
				if (textSu.length() == 0) {
					JOptionPane.showMessageDialog(Ex2shopTable.this, "수량을 입력해주세요.");
					return;
				} else {
					su = Integer.parseInt(textSu);
				}

				String textDan = tfDan.getText();
				int danga = 0;
				if (textDan.length() == 0) {
					JOptionPane.showMessageDialog(Ex2shopTable.this, "단가를 입력해주세요.");
					return;
				} else {
					danga = Integer.parseInt(textDan);
				}

				// insert 실행
				shopModel.insertShop(new ShopDto(sangpum, su, danga));
				// 전체 데이터 다시 출력
				rowSelect();
				// 입력 데이터 초기화
				tfSang.setText("");
				tfSu.setText("");
				tfDan.setText("");
			}
		});

		// 삭제 버튼
		delBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 테이블에서 idx(인덱스) 가져와서 삭제
				int row = table.getSelectedRow(); // 선택한 행번호 가져오기

				if (row == -1) {
					JOptionPane.showMessageDialog(Ex2shopTable.this, "삭제할 행을 먼저 선택해주세요.");
					return;
				}

				// 선택한 행의 0번열: idx
				// table.getValueAt - 반환 타입 Object >> String >> int
				int idx = Integer.parseInt(table.getValueAt(row, 0).toString());

				// 삭제 메소드 호출
				shopModel.deleteShop(idx);
				rowSelect();
			}

		});

		// 수정 버튼
		updateBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 행 먼저 선택 후 데이터 입력
				int row = table.getSelectedRow();

				if (row == -1) {
					JOptionPane.showMessageDialog(Ex2shopTable.this, "수정할 행을 먼저 선택해주세요.");
					return;
				}

				int idx = Integer.parseInt((String) table.getValueAt(row, 0));

				String sangpum;
				int su, danga;

				sangpum = JOptionPane.showInputDialog("수정할 상품명 입력");
				su = Integer.parseInt(JOptionPane.showInputDialog("수정할 수량 입력"));
				danga = Integer.parseInt(JOptionPane.showInputDialog("수정할 단가 입력"));

				shopModel.updateShop(idx, sangpum, su, danga);

				rowSelect();

			}
		});

		// 상품조회
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 상품명에 입력한 값을 찾기, 입력 안하면 전체 출력
				String sangpum = tfSang.getText();
				if (sangpum.length() == 0)
					rowSelect();
				else {
					tableModel.setRowCount(0);
					List<Vector<String>> s_list = shopModel.getSearchData(sangpum);
					for (Vector<String> v : s_list)
						tableModel.addRow(v);

					tfSang.setText("");
				}

			}
		});

	}

	// table에 데이터 출력
	public void rowSelect() {
		// 기존 테이블의 데이터 모두 삭제
		tableModel.setRowCount(0);

		// DB의 모든 데이터 가져오기
		List<Vector<String>> list = shopModel.getAlldatas();
		for (Vector<String> v : list) {
			tableModel.addRow(v);
		}
	}

	public static void main(String[] args) {
		// JTable을 이용한 디자인
		Ex2shopTable ex2 = new Ex2shopTable();
	}

}
