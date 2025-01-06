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

public class Ex3PersonTable extends JFrame {
	JTextField tfName, tfAge, tfHp, tfBlood;
	JButton addBtn, delBtn, upBtn, searchBtn;
	DefaultTableModel tableModel;
	JTable table;

	PersonModel pm = new PersonModel();

	public Ex3PersonTable() {
		super("Person 테이블 관리");
		this.setBounds(300, 100, 600, 400);
		this.initDesign();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void initDesign() {
		JPanel p1 = new JPanel();
		tfName = new JTextField(6);
		tfAge = new JTextField(3);
		tfHp = new JTextField(10);
		tfBlood = new JTextField(3);

		p1.add(new JLabel("이름"));
		p1.add(tfName);
		p1.add(new JLabel("나이"));
		p1.add(tfAge);
		p1.add(new JLabel("혈액형"));
		p1.add(tfBlood);
		p1.add(new JLabel("핸드폰"));
		p1.add(tfHp);

		this.add("North", p1);

		String[] title = { "회원번호", "이름", "나이", "혈액형", "핸드폰" };
		tableModel = new DefaultTableModel(title, 0);
		table = new JTable(tableModel);
		this.add("Center", new JScrollPane(table));

		this.rowSelect();

		addBtn = new JButton("회원추가");
		delBtn = new JButton("회원삭제");
		upBtn = new JButton("회원갱신");
		searchBtn = new JButton("회원조회");

		JPanel p2 = new JPanel();
		p2.add(addBtn);
		p2.add(delBtn);
		p2.add(upBtn);
		p2.add(searchBtn);
		this.add("South", p2);

		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "이름 입력!");
					return;
				}

				String textAge = tfAge.getText();
				int age = 0;
				if (name.length() == 0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "나이 입력!");
					return;
				}

				String blood = tfBlood.getText();
				if (blood.length() == 0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "혈액형 입력!");
					return;
				}

				String hp = tfHp.getText();
				if (hp.length() == 0) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "핸드폰 입력!");
					return;
				}

				pm.insertP(new PersonDTO(name, age, blood, hp));
				rowSelect();
				initTf();
			}
		});

		delBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (row == -1) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "삭제 행 선택!");
					return;
				}

				int idx = Integer.parseInt((String) table.getValueAt(row, 0));
				pm.deleteP(idx);
				rowSelect();

			}
		});

		upBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (row == -1) {
					JOptionPane.showMessageDialog(Ex3PersonTable.this, "수정할 행 선택!");
					return;
				}

				int idx = Integer.parseInt((String) table.getValueAt(row, 0));

				String name, blood, hp;
				int age;

				name = JOptionPane.showInputDialog("이름");
				age = Integer.parseInt(JOptionPane.showInputDialog("나이"));
				blood = JOptionPane.showInputDialog("혈액형");
				hp = JOptionPane.showInputDialog("핸드폰");

				pm.updateP(idx, name, age, blood, hp);

				rowSelect();

			}
		});

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				if (name.length() == 0)
					rowSelect();
				else {
					tableModel.setRowCount(0);
					List<Vector<String>> s_list = pm.searchP(name);
					for (Vector<String> v : s_list)
						tableModel.addRow(v);

					initTf();
				}

			}
		});
	}

	public void initTf() {
		tfName.setText("");
		tfAge.setText("");
		tfHp.setText("");
		tfBlood.setText("");
	}

	public void rowSelect() {
		tableModel.setRowCount(0);

		List<Vector<String>> list = pm.getAllDatas();
		for (Vector<String> v : list)
			tableModel.addRow(v);
	}

	public static void main(String[] args) {
		Ex3PersonTable ex3 = new Ex3PersonTable();
	}

}
