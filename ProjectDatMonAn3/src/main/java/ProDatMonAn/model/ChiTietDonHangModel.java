package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chitietdonhang")
public class ChiTietDonHangModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idctdonhang;
	@Column
	private int  mamonan;
	@Column
	private int giagoc;
	@Column(nullable = false)	
	private int giakhuyenmai;
	
	@Column
	private int soluong;
	@Column
	private int iddonhang;
	public int getGiakhuyenmai() {
		return giakhuyenmai;
	}
	public void setGiakhuyenmai(int giakhuyenmai) {
		this.giakhuyenmai = giakhuyenmai;
	}
	public int getIddonhang() {
		return iddonhang;
	}
	public void setIddonhang(int iddonhang) {
		this.iddonhang = iddonhang;
	}
	public int getIDCTDonHang() {
		return idctdonhang;
	}
	public void setIDCTDonHang(int iDCTDonHang) {
		idctdonhang = iDCTDonHang;
	}
	public int getMamonan() {
		return mamonan;
	}
	public void setMamonan(int mamonan) {
		this.mamonan = mamonan;
	}
	public int getGia() {
		return giagoc;
	}
	public void setGia(int gia) {
		this.giagoc = gia;
	}
	public int getSoLuong() {
		return soluong;
	}
	public void setSoLuong(int soLuong) {
		soluong = soLuong;
	}
	public ChiTietDonHangModel(int mamonan, int gia, int soLuong,int iddonhang,int giakhuyenmai) {
		super();
		this.mamonan = mamonan;
		this.giagoc = gia;
		this.soluong = soLuong;
		this.iddonhang=iddonhang;
		this.giakhuyenmai=giakhuyenmai;
	}
	public ChiTietDonHangModel() {
		super();
	}
	
}
