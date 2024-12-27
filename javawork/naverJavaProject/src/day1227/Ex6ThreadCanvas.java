package day1227;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex6ThreadCanvas extends JFrame implements ActionListener {
	JButton startBtn, stopBtn;
	MyDraw draw = new MyDraw();
	boolean loop = false; // true: 원이 무한으로 그려지기
	Color drawColor = new Color(180, 190, 200);
	int xpos, ypos;

	public Ex6ThreadCanvas(String title) {
		super(title);

		this.setLocation(100, 100); // 시작 위치
		this.setSize(500, 500);// 창 크기

		// 배경색 변경
//		this.getContentPane().setBackground(new Color(93, 199, 187));
//		this.getContentPane().setBackground(Color.yellow); 

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 종료
		this.initDesign();// 각종 컴포넌트 생성
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// 루프 시작과 끝
		if (o == startBtn)
			loop = true;
		else
			loop = false;

		// Thread - run 메소드 호출
		// 인터페이스 Runnable 을 구현했으므로 Thread 생성자에 현재클래스의 인스턴스를 보낸다
		Thread th = new Thread(draw);
		th.start();

	}

	// 캔버스 내부 클래스
	class MyDraw extends Canvas implements Runnable {

		@Override
		public void paint(Graphics g) {
//			super.paint(g);
			if (loop) {
				g.setColor(drawColor);
				g.fillOval(xpos, ypos, 60, 60);
			}

		}

		@Override
		public void run() {
			System.out.println("원 그리기");
			if (draw == null)
				return;

			while (loop) {
				// 랜덤 색상 구하기 0~255
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);

				drawColor = new Color(r, g, b);

				// 랜덤 x, y 좌표
				xpos = (int) (Math.random() * 450);
				ypos = (int) (Math.random() * 450);

				// 캔버스 paint 메소드 호출
				this.paint(getGraphics());

				try {
					Thread.sleep(300); // 1000 = 1초
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	public void initDesign() {
		// 캔버스를 센터에 배치
		this.add("Center", draw);

		JPanel p = new JPanel();
		startBtn = new JButton("스레드 Start");
		stopBtn = new JButton("스레드 Stop");

		p.add(startBtn);
		p.add(stopBtn);

		this.add("North", p);
		this.add("Center", draw);

		// 버튼 이벤트
		// this - actionPerformed 메서드를 구현한 클래스의 인스턴스
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
	}

	public static void main(String[] args) {
		Ex6ThreadCanvas a = new Ex6ThreadCanvas("스레드 예제");

//		Thread th = new Thread(a);
//		th.start();
	}

}
