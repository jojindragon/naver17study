package shop.data;

import java.sql.Timestamp;

public class ShopDto {
	private int idx;
	private String sangpum;
	private int su;
	private int danga;
	private Timestamp ipgoday;
		
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getDanga() {
		return danga;
	}
	public void setDanga(int danga) {
		this.danga = danga;
	}
	public Timestamp getIpgoday() {
		return ipgoday;
	}
	public void setIpgoday(Timestamp ipgoday) {
		this.ipgoday = ipgoday;
	}
	
	
}
