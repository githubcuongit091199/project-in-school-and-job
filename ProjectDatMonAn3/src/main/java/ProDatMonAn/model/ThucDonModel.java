package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="thucdon")
public class ThucDonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mathucdon;
	@Column
	private String tenthucdon;
	
	@Column
	private int manhahang;

	public int getMathucdon() {
		return mathucdon;
	}

	public void setMathucdon(int mathucdon) {
		this.mathucdon = mathucdon;
	}

	public String getTenthucdon() {
		return tenthucdon;
	}

	public void setTenthucdon(String tenthucdon) {
		this.tenthucdon = tenthucdon;
	}

	public int getManhahang() {
		return manhahang;
	}

	public void setManhahang(int manhahang) {
		this.manhahang = manhahang;
	}

	public ThucDonModel(String tenthucdon, int manhahang) {
		super();
		this.tenthucdon = tenthucdon;
		this.manhahang = manhahang;
	}

	public ThucDonModel() {
		super();
	}
	
	
}
