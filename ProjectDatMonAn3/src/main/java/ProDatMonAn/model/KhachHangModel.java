package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="khachhang")
public class KhachHangModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int makhachhang;
	@Column
	public String tenkhachhang;
	public int getMakhachhang() {
		return makhachhang;
	}
	public KhachHangModel() {
		super();
	}
	public KhachHangModel(String tenkhachhang, String diachi, String sdt, int mataikhoan) {
		super();
		this.tenkhachhang = tenkhachhang;
		this.diachi = diachi;
		this.sdt = sdt;
		this.mataikhoan = mataikhoan;
	}
	public void setMakhachhang(int makhachhang) {
		this.makhachhang = makhachhang;
	}
	public String getTenkhachhang() {
		return tenkhachhang;
	}
	public void setTenkhachhang(String tenkhachhang) {
		this.tenkhachhang = tenkhachhang;
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
	@Column
	public String diachi;
	@Column
	public String sdt;
	@Column
	public int mataikhoan;
	@Column
	public String trangthai;
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	
}
