package day1220;

import day1220_2.Apple;

class Orange extends Apple {
	public void play() {
		this.job(); // public
		this.study(); // protected
//		this.draw(); - 오류 발생: default는 패키지가 다르면 접근 불가
		this.process();
	}
	
	@Override
	 protected void process() {
//	public void process() { // 부모보다 더 넓은 범위로 허용 -> 여기서는 default, private 오류
		super.process();
		System.out.println("Oracle, Mysql 공부를 deep하고 even하게");
	}
}

public class Ex4Inheri {

	public static void main(String[] args) {
		Orange o = new Orange();
		o.play();
	}
}
