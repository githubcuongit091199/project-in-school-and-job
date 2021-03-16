package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monan")
public class MonAnModel {

	public  MonAnModel() {
		// TODO Auto-generated constructor stub
	 
		super();
	}
	@Column
	private int mathucdon;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mamonan;
		
	@Column
	private int gia;
	@Column
	private String tenmonan;
	@Column
	private int khuyenmai;
	@Column
	private String hinhanh;
	@Column
	private String thongtin;	
	@Column
	private int iddanhmuc;
	@Column
	private String trangthai;
	
	
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public int getIddanhmuc() {
		return iddanhmuc;
	}
	public void setIddanhmuc(int iddanhmuc) {
		this.iddanhmuc = iddanhmuc;
	}
	public int getMathucdon() {
		return mathucdon;
	}
	public void setMathucdon(int mathucdon) {
		this.mathucdon = mathucdon;
	}
	public int getMamonan() {
		return mamonan;
	}
	public void setMamonan(int mamonan) {
		this.mamonan = mamonan;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getTenmonan() {
		return tenmonan;
	}
	public void setTenmonan(String tenmonan) {
		this.tenmonan = tenmonan;
	}
	public int getKhuyenmai() {
		return khuyenmai;
	}
	public void setKhuyenmai(int khuyenmai) {
		this.khuyenmai = khuyenmai;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getThongtin() {
		return thongtin;
	}
	public void setThongtin(String thongtin) {
		this.thongtin = thongtin;
	}
	public MonAnModel(int mathucdon, int gia, String tenmonan, int khuyenmai, String hinhanh,
			String thongtin, int iddanhmuc) {
		super();
		this.mathucdon = mathucdon;
		this.gia = gia;
		this.tenmonan = tenmonan;
		this.khuyenmai = khuyenmai;
		this.hinhanh = hinhanh;
		this.thongtin = thongtin;
		this.iddanhmuc= iddanhmuc;

	}

	
	
	
	
	
	
}
