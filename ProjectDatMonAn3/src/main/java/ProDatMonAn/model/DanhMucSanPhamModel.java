package ProDatMonAn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="danhmucsanpham")
public class DanhMucSanPhamModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddanhmuc;
	
	@Column
	private String loaimonan;
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
	public String getLoaimonan() {
		return loaimonan;
	}
	public void setLoaimonan(String loaimonan) {
		this.loaimonan = loaimonan;
	}
	public DanhMucSanPhamModel(String loaimonan) {
		super();
		this.loaimonan = loaimonan;

	}
	public DanhMucSanPhamModel() {
		super();
	}
	
	
}
