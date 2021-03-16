package ProDatMonAn.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donhangdat")
public class DonDatHangModel {
	@Column
	private int idshipper;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddonhang;
	@Column
	private int soluong;
	@Column
	private int tongtien;
	@Column
	private String ngaygio;
	@Column
	private int idkhachhang;
	@Column
	private String trangthai;
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public DonDatHangModel() {
		super();
	}
	public DonDatHangModel(int idshipper, int soluong, int tongtien, String ngaygio, int idkhachhang) {
		super();
		this.idshipper = idshipper;
		this.soluong = soluong;
		this.tongtien = tongtien;
		this.ngaygio = ngaygio;
		this.idkhachhang = idkhachhang;
	
	}
	public int getIdshipper() {
		return idshipper;
	}
	public void setIdshipper(int idshipper) {
		this.idshipper = idshipper;
	}
	public int getIddonhang() {
		return iddonhang;
	}
	public void setIddonhang(int iddonhang) {
		this.iddonhang = iddonhang;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public String getNgaygio() {
		return ngaygio;
	}
	public void setNgaygio(String date) {
		this.ngaygio =  date;
	}
	public int getIdkhachhang() {
		return idkhachhang;
	}
	public void setIdkhachhang(int idkhachhang) {
		this.idkhachhang = idkhachhang;
	}

}
