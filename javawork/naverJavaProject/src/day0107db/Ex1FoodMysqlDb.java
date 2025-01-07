package day0107db;

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

public class Ex1FoodMysqlDb extends JFrame {
	FoodModel fm = new FoodModel();

	DefaultTableModel foodResTableModel;
	DefaultTableModel foodOrderTableModel;
	JTable foodResTable;
	JTable foodOrderTable;

	JButton foodResAddBtn, foodResDelBtn;
	JButton foodOrderAddBtn, foodOrderDelBtn;
	JTextField tfFoodNum, tfOrderName, tfOrderCnt, tfBookingDay;
	JTextField tfFoodName, tfFoodPrice, tfFoodSize;

	public Ex1FoodMysqlDb() {
		super("메뉴등록&예약");
		this.setBounds(200, 100, 1000, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		JPanel p1 = new JPanel();
		foodResAddBtn = new JButton("메뉴등록");
		foodResDelBtn = new JButton("메뉴삭제");
		foodOrderAddBtn = new JButton("예약하기");
		foodOrderDelBtn = new JButton("예약취소");

		tfFoodName = new JTextField(7);
		tfFoodPrice = new JTextField(7);
		tfFoodSize = new JTextField(5);

		p1.add(new JLabel("메뉴명"));
		p1.add(tfFoodName);
		p1.add(new JLabel("가격등록"));
		p1.add(tfFoodPrice);
		p1.add(new JLabel("사이즈"));
		p1.add(tfFoodSize);

		p1.add(foodResAddBtn);
		p1.add(foodResDelBtn);
		p1.add(foodOrderAddBtn);
		p1.add(foodOrderDelBtn);
		this.add("North", p1);

		// 왼쪽 - 메뉴판: foodrest
		String[] menuTitle = { "번호", "메뉴명", "가격", "사이즈" };
		foodResTableModel = new DefaultTableModel(menuTitle, 0); // 제목, 행갯수 -> 0으로
		foodResTable = new JTable(foodResTableModel);
		this.add("West", new JScrollPane(foodResTable));

		writeFoodMenu(); // DB 데이터 메뉴 테이블에 출력

		// 가운데 - 예약 내역: foodorder
		String[] orderTitle = { "번호", "예약자", "메뉴명", "가격", "사이즈", "인원수", "예약일" };
		foodOrderTableModel = new DefaultTableModel(orderTitle, 0);
		foodOrderTable = new JTable(foodOrderTableModel);
		this.add("Center", new JScrollPane(foodOrderTable));

		writeFoodOrderJoin(); // 예약내용 출력

		// 하단 - 예약내용 입력
		tfOrderName = new JTextField(5);
		tfOrderCnt = new JTextField(3);
		tfBookingDay = new JTextField(10);
		tfFoodNum = new JTextField(3);

		JPanel p2 = new JPanel();
		p2.add(new JLabel("메뉴번호"));
		p2.add(tfFoodNum);
		p2.add(new JLabel("예약자명"));
		p2.add(tfOrderName);
		p2.add(new JLabel("인원수"));
		p2.add(tfOrderCnt);
		p2.add(new JLabel("예약시간"));
		p2.add(tfBookingDay);

		this.add("South", p2);

		// 버튼 이벤트

		// 메뉴 등록
		foodResAddBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String foodName = tfFoodName.getText();
				int foodPrice = Integer.parseInt(tfFoodPrice.getText());
				String foodSize = tfFoodSize.getText();

				fm.foodMenuInsert(foodName, foodPrice, foodSize);
				writeFoodMenu();
				initText();
			}
		});

		// 메뉴 삭제
		foodResDelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = foodResTable.getSelectedRow();

				if (row == -1) {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제할 메뉴를 선택!");
					return;
				}
				int num = Integer.parseInt(foodResTable.getValueAt(row, 0).toString());
				int cnt = fm.getOrderMenuCount(num);

				if (cnt == 0) {
					fm.deleteFoodMenu(num);
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제 완료");
					writeFoodMenu();
				} else {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "예약자가 존재한다. 먼저 취소해라.");
				}

			}
		});

		// 예약
		foodOrderAddBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력값 읽기
				int num = Integer.parseInt(tfFoodNum.getText());
				String orderName = tfOrderName.getText();
				int orderCnt = Integer.parseInt(tfOrderCnt.getText());
				String bookingDay = tfBookingDay.getText();

				// dto 에 대입
				FoodOrderDTO dto = new FoodOrderDTO(num, orderName, orderCnt, bookingDay);

				// 예약 insert
				fm.foodOrderInsert(dto);
				// 재출력
				writeFoodOrderJoin();
				initText();
			}
		});

		// 예약 취소
		foodOrderDelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = foodOrderTable.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "예약 건수를 선택!");
					return;
				}

				fm.deleteOrder(Integer.parseInt(foodOrderTable.getValueAt(row, 0).toString()));
				writeFoodOrderJoin();
			}
		});

	}

	public void writeFoodMenu() {
		// 메뉴 가져오기
		foodResTableModel.setRowCount(0);

		List<Vector<String>> menuList = fm.getMenus();
		for (Vector<String> v : menuList)
			foodResTableModel.addRow(v);
	}

	public void writeFoodOrderJoin() {
		// 예약 내역 가져오기
		foodOrderTableModel.setRowCount(0);

		List<Vector<String>> orderList = fm.getOrders();
		for (Vector<String> v : orderList)
			foodOrderTableModel.addRow(v);
	}

	public void initText() {
		tfFoodName.setText("");
		tfFoodPrice.setText("");
		tfFoodSize.setText("");

		tfFoodNum.setText("");
		tfOrderName.setText("");
		tfOrderCnt.setText("");
		tfBookingDay.setText("");
	}

	public static void main(String[] args) {
		Ex1FoodMysqlDb ex1 = new Ex1FoodMysqlDb();

	}

}
