package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="magiamgia")
public class MaGiamGiaModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int iddiscount;
	@Column
	public String startdate;
	@Column
	public String finishdate;
	@Column
	public int money;
	@Column
	public String tenma;
	@Column
	private String trangthai;//xem lại
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public int getIddiscount() {
		return iddiscount;
	}
	public void setIddiscount(int iddiscount) {
		this.iddiscount = iddiscount;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getFinishdate() {
		return finishdate;
	}
	public void setFinishdate(String finishdate) {
		this.finishdate = finishdate;
	}
	public int getMoney() {
		return money;
	}
	public MaGiamGiaModel(String startdate, String finishdate, int money, String tenma) {
		super();
		this.startdate = startdate;
		this.finishdate = finishdate;
		this.money = money;
		this.tenma = tenma;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getTenma() {
		return tenma;
	}
	public void setTenma(String tenma) {
		this.tenma = tenma;
	}
	public MaGiamGiaModel() {
		super();
	}
	
	
}
