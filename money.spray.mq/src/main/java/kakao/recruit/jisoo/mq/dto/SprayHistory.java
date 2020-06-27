package kakao.recruit.jisoo.mq.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SprayHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private int s_price;
	private int r_price;
	private String s_user;
	private String r_user;
	private String r_succ;
	private long regDate;
	
	public SprayHistory() {
		
	}
	public SprayHistory(int s_price,int r_price,String s_user,String r_user,String r_succ,long regDate) {
		this.s_price = s_price;
		this.r_price = r_price;
		this.s_user = s_user;
		this.r_user = r_user;
		this.r_succ = r_succ;
		this.regDate = regDate;
	}
	public Integer getId() {
	    return id;
	  }

	  public void setId(Integer id) {
	    this.id = id;
	  }
	public int getS_price() {
		return s_price;
	}
	public void setS_price(int s_price) {
		this.s_price = s_price;
	}
	public int getR_price() {
		return r_price;
	}
	public void setR_price(int r_price) {
		this.r_price = r_price;
	}
	public String getS_user() {
		return s_user;
	}
	public void setS_user(String s_user) {
		this.s_user = s_user;
	}
	public String getR_user() {
		return r_user;
	}
	public void setR_user(String r_user) {
		this.r_user = r_user;
	}
	public String getR_succ() {
		return r_succ;
	}
	public void setR_succ(String r_succ) {
		this.r_succ = r_succ;
	}
	public long getRegDate() {
		return regDate;
	}
	public void setRegDate(long regDate) {
		this.regDate = regDate;
	}
	
	
}
