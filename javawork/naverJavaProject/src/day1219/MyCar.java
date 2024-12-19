package day1219;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCar { // 데이터 클래스
	private String name;
	private String purchaseDay;
	private String color;
	private int price;

	public MyCar() {
		// 생성되는 시간을 구매 날짜를 구해서 넣기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		purchaseDay = sdf.format(new Date());

		color = "흰색";

	}

	public MyCar(String name, String color, int price) {
//		super();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		purchaseDay = sdf.format(new Date());

		this.name = name;
		this.color = color;
		this.price = price;
	}

	// @Annotation
	@Override
	public String toString() {
		return "MyCar [carName=" + name + ", carPrice=" + price + "\n구매 일자: " + purchaseDay + ", 차량 색: " + color + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurchaseDay() {
		return purchaseDay;
	}

	public void setPurchaseDay(String purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
