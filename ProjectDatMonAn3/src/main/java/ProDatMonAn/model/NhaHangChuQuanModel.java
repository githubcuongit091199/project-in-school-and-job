package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nhahangchuquan")
public class NhaHangChuQuanModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int manhahang; 
		
	@Column
	private String tennhahang; 
	@Column
	private String diachi;
	@Column
	private String sdt;
	@Column
	private int mataikhoan;
	@Column
	private String trangthai;
	@Column
	private String hinhanh;
	
	
	
	public String getHinhanh() {
		return hinhanh;
	}


	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}


	public String getTrangthai() {
		return trangthai;
	}


	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}


	public NhaHangChuQuanModel(String tennhahang, String diachi, String sdt, int mataikhoan) {
		super();
		this.tennhahang = tennhahang;
		this.diachi = diachi;
		this.sdt = sdt;
		this.mataikhoan = mataikhoan;
	
	}
	
	
	public NhaHangChuQuanModel() {
		super();
	}


	

	public int getManhahang() {
		return manhahang;
	}
	public void setManhahang(int manhahang) {
		this.manhahang = manhahang;
	}
	public String getTennhahang() {
		return tennhahang;
	}
	public void setTennhahang(String tennhahang) {
		this.tennhahang = tennhahang;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getMataikhoan() {
		return mataikhoan;
	}
	public void setMataikhoan(int mataikhoan) {
		this.mataikhoan = mataikhoan;
	}
}
