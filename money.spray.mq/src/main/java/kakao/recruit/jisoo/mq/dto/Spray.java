package kakao.recruit.jisoo.mq.dto;

import java.util.Date;

public class Spray {
	private int id;
	private int price;
	private String s_user;
	private long regDate;
	
	public Spray( int id,int price,String s_user,long regDate) {
		this.id = id;
		this.price = price;
		this.s_user = s_user;
		this.regDate = regDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getS_user() {
		return s_user;
	}
	public void setS_user(String s_user) {
		this.s_user = s_user;
	}
	public long getRegDate() {
		return regDate;
	}
	public void setRegDate(long regDate) {
		this.regDate = regDate;
	}
	
	
	
}
